package com.example.moviecollection.entity.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.SeriesEntity

@Dao
interface CollectionDao {

    @RawQuery(observedEntities = [MovieEntity::class])
    fun getMovies(query: SupportSQLiteQuery): DataSource.Factory<Int, MovieEntity>

    @RawQuery(observedEntities = [SeriesEntity::class])
    fun getSeries(query: SupportSQLiteQuery): DataSource.Factory<Int, SeriesEntity>

    @Query("SELECT * FROM movieentities where bookmarked = 1")
    fun getBookmarkedMovies(): DataSource.Factory<Int,MovieEntity>

    @Query("SELECT * FROM seriesentities where bookmarked =1")
    fun getBookmarkedSeries(): DataSource.Factory<Int,SeriesEntity>

    @Query("SELECT * FROM movieentities where movieId =:movieId")
    fun getMoviesItem(movieId: String): LiveData<MovieEntity>

    @Query("SELECT * FROM seriesentities where seriesId =:seriesId")
    fun getSeriesItem(seriesId: String): LiveData<SeriesEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertSeries(series: List<SeriesEntity>)

    @Update
    fun updateMovies(movieEntity: MovieEntity)

    @Update
    fun updateSeries(seriesEntity: SeriesEntity)
}