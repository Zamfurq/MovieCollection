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
import com.example.moviecollection.databinding.FragmentSeriesFavoriteBinding
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.ui.ViewModelFactory
import com.example.moviecollection.ui.tvseries.SeriesCallback
import com.google.android.material.snackbar.Snackbar


class SeriesFavoriteFragment : Fragment(), SeriesCallback {

    private var fragmentSeriesFavoriteBinding: FragmentSeriesFavoriteBinding? = null
    private val binding get() = fragmentSeriesFavoriteBinding

    private lateinit var adapter: SeriesFavoriteAdapter
    private lateinit var viewModel: SeriesFavoriteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSeriesFavoriteBinding = FragmentSeriesFavoriteBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvSeriesBookmark)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[SeriesFavoriteViewModel::class.java]
            adapter = SeriesFavoriteAdapter(this)
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getBookmarks().observe(viewLifecycleOwner, {series ->
                binding?.progressBar?.visibility = View.GONE
                adapter.submitList(series)
                adapter.notifyDataSetChanged()
            })
            binding?.rvSeriesBookmark?.layoutManager = LinearLayoutManager(context)
            binding?.rvSeriesBookmark?.setHasFixedSize(true)
            binding?.rvSeriesBookmark?.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentSeriesFavoriteBinding = null
    }

    override fun onShareClick(series: SeriesEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share the TV Series?")
                .setText(resources.getString(R.string.share_text, series.title))
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
                val seriesEntity = adapter.getSwipedData(swipedPosition)
                seriesEntity?.let { viewModel.setBookmark(it) }

                val snackbar = Snackbar.make(view as View, R.string.undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.ok) {v ->
                    seriesEntity?.let { viewModel.setBookmark(it) }
                }
                snackbar.show()
            }
        }

    })
}