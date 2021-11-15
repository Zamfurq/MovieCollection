package com.example.moviecollection.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecollection.R
import com.example.moviecollection.databinding.FragmentMovieFavoriteBinding
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.ui.ViewModelFactory
import com.example.moviecollection.ui.movies.MovieCallback
import com.google.android.material.snackbar.Snackbar


class MovieFavoriteFragment : Fragment(), MovieCallback {

    private var fragmentMovieFavoriteBinding: FragmentMovieFavoriteBinding? = null
    private val binding get() = fragmentMovieFavoriteBinding

    private lateinit var viewModel: MovieFavoriteViewModel
    private lateinit var adapter: MovieFavoriteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieFavoriteBinding = FragmentMovieFavoriteBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvMovieBookmark)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieFavoriteViewModel::class.java]
            adapter = MovieFavoriteAdapter(this)
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getBookmarks().observe(viewLifecycleOwner, {movie ->
                binding?.progressBar?.visibility = View.GONE
                adapter.submitList(movie)
                adapter.notifyDataSetChanged()
            })
            binding?.rvMovieBookmark?.layoutManager = LinearLayoutManager(context)
            binding?.rvMovieBookmark?.setHasFixedSize(true)
            binding?.rvMovieBookmark?.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentMovieFavoriteBinding = null
    }

    override fun onShareClick(movie: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share the TV Series?")
                .setText(resources.getString(R.string.share_text, movie.title))
                .startChooser()
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            return makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movieEntity = adapter.getSwipedData(swipedPosition)
                movieEntity?.let { viewModel.setBookmark(it) }

                val snackbar = Snackbar.make(view as View, R.string.undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.ok) {v ->
                    movieEntity?.let { viewModel.setBookmark(it) }
                }
                snackbar.show()
            }
        }

    })


}