package com.example.moviecollection.entity.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.entity.source.local.room.CollectionDao
import com.example.moviecollection.utility.SortUtils

class LocalDataSource private constructor(private val collectionDao: CollectionDao){
    companion object {
        private val INSTANCE: LocalDataSource? = null

        fun getInstance(collectionDao: CollectionDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(collectionDao)
    }

    fun getAllMovies(sort: String): DataSource.Factory<Int,MovieEntity> {
        val query = SortUtils.getSortedQueryMovies(sort)
        return collectionDao.getMovies(query)
    }

    fun getBookmarkedMovies(): DataSource.Factory<Int,MovieEntity> = collectionDao.getBookmarkedMovies()

    fun getAllSeries(sort: String): DataSource.Factory<Int,SeriesEntity>{
        val query = SortUtils.getSortedQuerySeries(sort)
        return collectionDao.getSeries(query)
    }

    fun getBookmarkedSeries(): DataSource.Factory<Int,SeriesEntity> = collectionDao.getBookmarkedSeries()

    fun insertMovies(movie: List<MovieEntity>) = collectionDao.insertMovies(movie)

    fun insertSeries(series: List<SeriesEntity>) = collectionDao.insertSeries(series)

    fun updateMovies(movieEntity: MovieEntity) = collectionDao.updateMovies(movieEntity)

    fun updateSeries(seriesEntity: SeriesEntity) = collectionDao.updateSeries(seriesEntity)

    fun getMoviesItem(movieId: String): LiveData<MovieEntity> = collectionDao.getMoviesItem(movieId)

    fun getSeriesItem(seriesId: String) : LiveData<SeriesEntity> = collectionDao.getSeriesItem(seriesId)

    fun setMoviesBookmark(movieEntity: MovieEntity, newState: Boolean) {
        movieEntity.bookmarked = newState
        collectionDao.updateMovies(movieEntity)
    }

    fun setSeriesBookmark(seriesEntity: SeriesEntity, newState: Boolean) {
        seriesEntity.bookmarked = newState
        collectionDao.updateSeries(seriesEntity)
    }
}