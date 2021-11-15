package com.example.moviecollection.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.source.CollectionRepository
import com.example.moviecollection.vo.Resource

class MovieViewModel(private val collectionRepository: CollectionRepository): ViewModel() {
    fun getMovies(sort: String): LiveData<Resource<PagedList<MovieEntity>>> {
        return collectionRepository.getMovies(sort)
    }
}