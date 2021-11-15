package com.example.moviecollection.entity.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.vo.Resource

interface CollectionDataSource {

    fun getMovies(sort: String): LiveData<Resource<PagedList<MovieEntity>>>

    fun getSeries(sort: String): LiveData<Resource<PagedList<SeriesEntity>>>

    fun getMoviesItem(movieId: String): LiveData<Resource<MovieEntity>>

    fun getSeriesItem(seriesId: String): LiveData<Resource<SeriesEntity>>

    fun getBookmarkedMovies(): LiveData<PagedList<MovieEntity>>

    fun getBookmarkedSeries(): LiveData<PagedList<SeriesEntity>>

    fun setMovieBookmark(movieEntity: MovieEntity, state: Boolean)

    fun setSeriesBookmark(seriesEntity: SeriesEntity, state: Boolean)
}