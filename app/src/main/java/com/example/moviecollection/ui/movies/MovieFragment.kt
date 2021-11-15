package com.example.moviecollection.ui.movies

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecollection.R
import com.example.moviecollection.databinding.FragmentMovieBinding
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.ui.ViewModelFactory
import com.example.moviecollection.ui.favorite.FavoriteActivity
import com.example.moviecollection.utility.SortUtils
import com.example.moviecollection.vo.Status


class MovieFragment : Fragment(), MovieCallback {

    private var fragmentMovieBinding: FragmentMovieBinding? = null
    private val binding get() = fragmentMovieBinding

    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            movieAdapter = MovieAdapter(this)
            viewModel.getMovies(SortUtils.DEFAULT).observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            movieAdapter.submitList(movies.data)
                            movieAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding?.rvMovie) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = movieAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentMovieBinding = null
    }

    override fun onShareClick(movie: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share the film?")
                .setText(resources.getString(R.string.share_text, movie.title))
                .startChooser()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater){
        menuInflater.inflate(R.menu.menu_favorite,menu)
        super.onCreateOptionsMenu(menu,menuInflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sort = ""
        when (item.itemId) {
            R.id.bookmark -> {
                val intent = Intent(context, FavoriteActivity::class.java)
                startActivity(intent)
            }
            R.id.action_asc -> sort = SortUtils.ASCENDING
            R.id.action_desc -> sort = SortUtils.DESCENDING
            R.id.action_default -> sort = SortUtils.DEFAULT
        }
        viewModel.getMovies(sort).observe(this, {movies ->
            if (movies != null) {
                movieAdapter.submitList(movies.data)
            }
        })
        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }

}