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
import com.example.moviecollection.databinding.ActivityDetailMovieBinding
import com.example.moviecollection.databinding.ContentDetailMovieBinding
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.ui.ViewModelFactory
import com.example.moviecollection.vo.Status
import java.util.*


class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var contentDetailMovieBinding: ContentDetailMovieBinding

    private lateinit var viewModel: DetailMovieViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        contentDetailMovieBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)
        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                viewModel.movies.observe(this, {moviesResource ->
                    if (moviesResource != null) {
                        when (moviesResource.status) {
                            Status.LOADING -> activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (moviesResource.data != null) {
                                activityDetailMovieBinding.progressBar.visibility = View.GONE
                                activityDetailMovieBinding.content.visibility = View.VISIBLE

                                populateCourse(moviesResource.data)
                            }
                            Status.ERROR -> {
                                activityDetailMovieBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

            }
        }

    }

    private fun populateCourse(movieEntity: MovieEntity) {
        contentDetailMovieBinding.apply {
            tvMovieTitle.text = movieEntity.title
            tvVoteAverage.text = movieEntity.voteCount.toString()
            tvLanguage.text = movieEntity.originLanguage
            tvMovieYear.text = movieEntity.releaseYear
            tvSynopsisDetail.text = movieEntity.synopsis
        }


        Glide.with(this)
            .load(movieEntity.poster)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(contentDetailMovieBinding.imgPosterMovie)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail,menu)
        this.menu = menu
        viewModel.movies.observe(this, {movies ->
            if (movies != null) {
                when(movies.status) {
                    Status.LOADING -> activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (movies.data != null) {
                        activityDetailMovieBinding.progressBar.visibility = View.GONE
                        val state = movies.data.bookmarked
                        setBookmarked(state)
                    }
                    Status.ERROR -> {
                        activityDetailMovieBinding.progressBar.visibility = View.GONE
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