package com.example.moviecollection.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviecollection.entity.source.CollectionRepository
import com.example.moviecollection.injection.Injection
import com.example.moviecollection.ui.detail.DetailMovieViewModel
import com.example.moviecollection.ui.detail.DetailSeriesViewModel
import com.example.moviecollection.ui.favorite.MovieFavoriteViewModel
import com.example.moviecollection.ui.favorite.SeriesFavoriteViewModel
import com.example.moviecollection.ui.movies.MovieViewModel
import com.example.moviecollection.ui.tvseries.SeriesViewModel

class ViewModelFactory private constructor(private val collectionRepository: CollectionRepository): ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(collectionRepository) as T
            }
            modelClass.isAssignableFrom(SeriesViewModel::class.java) -> {
                return SeriesViewModel(collectionRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(collectionRepository) as T
            }
            modelClass.isAssignableFrom(DetailSeriesViewModel::class.java) -> {
                return DetailSeriesViewModel(collectionRepository) as T
            }
            modelClass.isAssignableFrom(MovieFavoriteViewModel::class.java) -> {
                return MovieFavoriteViewModel(collectionRepository) as T
            }
            modelClass.isAssignableFrom(SeriesFavoriteViewModel::class.java) -> {
                return SeriesFavoriteViewModel(collectionRepository) as T
            }
            else -> throw Throwable("Unknown View Model Class: " + modelClass.name)
        }
    }
}