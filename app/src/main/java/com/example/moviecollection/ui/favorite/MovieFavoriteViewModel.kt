package com.example.moviecollection.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.source.CollectionRepository

class MovieFavoriteViewModel(private val collectionRepository: CollectionRepository): ViewModel() {
    fun getBookmarks(): LiveData<PagedList<MovieEntity>> {
        return collectionRepository.getBookmarkedMovies()
    }

    fun setBookmark(movieEntity: MovieEntity) {
        val newState = !movieEntity.bookmarked
        collectionRepository.setMovieBookmark(movieEntity, newState)
    }
}