package com.example.moviecollection.ui.tvseries

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecollection.R
import com.example.moviecollection.databinding.FragmentSeriesBinding
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.ui.ViewModelFactory
import com.example.moviecollection.ui.favorite.FavoriteActivity
import com.example.moviecollection.ui.movies.MovieAdapter
import com.example.moviecollection.utility.SortUtils
import com.example.moviecollection.vo.Status


class SeriesFragment : Fragment(), SeriesCallback {

    private var fragmentSeriesBinding: FragmentSeriesBinding? = null
    private val binding get() = fragmentSeriesBinding

    private lateinit var viewModel: SeriesViewModel
    private lateinit var seriesAdapter: SeriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSeriesBinding = FragmentSeriesBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[SeriesViewModel::class.java]
            seriesAdapter = SeriesAdapter(this)
            viewModel.getSeries(SortUtils.DEFAULT).observe(viewLifecycleOwner, { series ->
                if (series != null) {
                    when(series.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.GONE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            seriesAdapter.submitList(series.data)
                            seriesAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding?.rvSeries) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = seriesAdapter
            }
        }
    }

    override fun onDestroy() {
        fragmentSeriesBinding = null
        super.onDestroy()
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

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater){
        menuInflater.inflate(R.menu.menu_favorite_series,menu)
        super.onCreateOptionsMenu(menu,menuInflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sort = ""
        when (item.itemId) {
            R.id.bookmark_series -> {
                val intent = Intent(context, FavoriteActivity::class.java)
                startActivity(intent)
            }
            R.id.action_asc_series -> sort = SortUtils.ASCENDING
            R.id.action_desc_series -> sort = SortUtils.DESCENDING
            R.id.action_default_series -> sort = SortUtils.DEFAULT
        }
        viewModel.getSeries(sort).observe(this, {movies ->
            if (movies != null) {
                seriesAdapter.submitList(movies.data)
            }
        })
        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }
}