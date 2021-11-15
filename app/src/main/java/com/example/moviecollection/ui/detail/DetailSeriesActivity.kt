package com.example.moviecollection.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecollection.R
import com.example.moviecollection.databinding.ActivityDetailSeriesBinding
import com.example.moviecollection.databinding.ContentDetailSeriesBinding
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.ui.ViewModelFactory
import com.example.moviecollection.vo.Status
import java.util.*


class DetailSeriesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SERIES = "extra_series"
    }

    private lateinit var activityDetailSeriesBinding: ActivityDetailSeriesBinding
    private lateinit var contentDetailSeriesBinding: ContentDetailSeriesBinding

    private lateinit var viewModel: DetailSeriesViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailSeriesBinding = ActivityDetailSeriesBinding.inflate(layoutInflater)
        contentDetailSeriesBinding = activityDetailSeriesBinding.detailContent
        setContentView(activityDetailSeriesBinding.root)
        setSupportActionBar(activityDetailSeriesBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailSeriesViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val seriesId = extras.getString(EXTRA_SERIES)
            if (seriesId != null) {
                viewModel.setSelectedSeries(seriesId)
                viewModel.series.observe(this, { seriesResource ->
                    if (seriesResource != null) {
                        when (seriesResource.status) {
                            Status.LOADING -> activityDetailSeriesBinding.progressBar.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (seriesResource.data != null) {
                                activityDetailSeriesBinding.progressBar.visibility = View.GONE
                                activityDetailSeriesBinding.content.visibility = View.VISIBLE
                                populateCourse(seriesResource.data)
                            }
                            Status.ERROR -> {
                                activityDetailSeriesBinding.progressBar.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }
    }

    private fun populateCourse(seriesEntity: SeriesEntity) {
        contentDetailSeriesBinding.apply {
            tvSeriesTitle.text = seriesEntity.title
            tvSeriesVoteAverage.text = seriesEntity.voteCount.toString()
            tvLanguageSeries.text = seriesEntity.originLanguage
            tvSeriesYear.text = seriesEntity.firstEpisodeYear
            tvSynopsisDetailSeries.text = seriesEntity.synopsis
        }


        Glide.with(this)
            .load(seriesEntity.poster)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(contentDetailSeriesBinding.imgPosterSeries)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail,menu)
        this.menu = menu
        viewModel.series.observe(this, {movies ->
            if (movies != null) {
                when(movies.status) {
                    Status.LOADING -> activityDetailSeriesBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (movies.data != null) {
                        activityDetailSeriesBinding.progressBar.visibility = View.GONE
                        val state = movies.data.bookmarked
                        setBookmarked(state)
                    }
                    Status.ERROR -> {
                        activityDetailSeriesBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    private fun setBookmarked(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_unbookmark_white)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_bookmark) {
            viewModel.setBookmark()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}