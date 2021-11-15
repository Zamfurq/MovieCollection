package com.example.moviecollection.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.source.CollectionRepository
import com.example.moviecollection.vo.Resource

class DetailMovieViewModel(private val collectionRepository: CollectionRepository): ViewModel() {
    val movieId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    var movies: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) {mMovieId ->
        collectionRepository.getMoviesItem(mMovieId)
    }

    fun setBookmark() {
        val moviesResource = movies.value
        if (moviesResource != null) {
            val moviesEntity = moviesResource.data
            if (moviesEntity != null) {
                val newState = !moviesEntity.bookmarked
                collectionRepository.setMovieBookmark(moviesEntity, newState)
            }
        }
    }
}