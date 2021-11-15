package com.example.moviecollection.entity.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.entity.source.local.LocalDataSource
import com.example.moviecollection.entity.source.remote.ApiResponse
import com.example.moviecollection.entity.source.remote.RemoteDataSource
import com.example.moviecollection.entity.source.remote.response.*
import com.example.moviecollection.utility.AppExecutors
import com.example.moviecollection.vo.Resource

class CollectionRepository private constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource, private val appExecutors: AppExecutors) : CollectionDataSource{
    companion object {
        @Volatile
        private var instance: CollectionRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): CollectionRepository =
            instance ?: synchronized(this) {
                instance ?: CollectionRepository(remoteDataSource, localDataSource, appExecutors).apply { instance = this }
            }
    }

    override fun getMovies(sort: String): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieItemResponse>>(appExecutors) {
            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(sort), config).build()
            }

            override fun saveCallResult(data: List<MovieItemResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(response.id.toString(),
                        response.title,
                        "https://image.tmdb.org/t/p/original"+response.posterPath,
                        response.overview,
                        response.originalLanguage,
                        response.releaseDate,
                        response.voteAverage,
                    false)
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieItemResponse>>> {
                return remoteDataSource.getMovies()
            }

        }.asLiveData()
    }

    override fun getSeries(sort: String): LiveData<Resource<PagedList<SeriesEntity>>> {
        return object: NetworkBoundResource<PagedList<SeriesEntity>, List<SeriesItemResponse>>(appExecutors) {
            override fun shouldFetch(data: PagedList<SeriesEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDB(): LiveData<PagedList<SeriesEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllSeries(sort), config).build()
            }

            override fun saveCallResult(data: List<SeriesItemResponse>) {
                val seriesList = ArrayList<SeriesEntity>()
                for (response in data) {
                    val series = SeriesEntity(response.id.toString(),
                        response.name,
                        "https://image.tmdb.org/t/p/original"+response.posterPath,
                        response.overview,
                        response.originalLanguage,
                        response.firstAirDate,
                        response.voteAverage,
                    false)
                    seriesList.add(series)
                }
                localDataSource.insertSeries(seriesList)
            }

            override fun createCall(): LiveData<ApiResponse<List<SeriesItemResponse>>> {
                return remoteDataSource.getSeries()
            }

        }.asLiveData()
    }

    override fun getMoviesItem(movieId: String): LiveData<Resource<MovieEntity>> {
        return object: NetworkBoundResource<MovieEntity, List<MovieItemResponse>>(appExecutors) {
            override fun shouldFetch(data: MovieEntity?): Boolean {
                return data == null
            }

            override fun loadFromDB(): LiveData<MovieEntity> {
                return localDataSource.getMoviesItem(movieId)
            }

            override fun saveCallResult(data: List<MovieItemResponse>) {
                lateinit var movie: MovieEntity
                for (response in data) {
                    if (response.id.toString() == movieId) {
                        movie = MovieEntity(
                            response.id.toString(),
                            response.title,
                            "https://image.tmdb.org/t/p/original" + response.posterPath,
                            response.overview,
                            response.originalLanguage,
                            response.releaseDate,
                            response.voteAverage,
                        false)
                    }
                }
                localDataSource.updateMovies(movie)
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieItemResponse>>> {
                return remoteDataSource.getMovies()
            }

        }.asLiveData()
    }


    override fun getSeriesItem(seriesId: String): LiveData<Resource<SeriesEntity>> {
        return object : NetworkBoundResource<SeriesEntity, List<SeriesItemResponse>>(appExecutors) {
            override fun shouldFetch(data: SeriesEntity?): Boolean {
                return data == null
            }

            override fun loadFromDB(): LiveData<SeriesEntity> {
                return localDataSource.getSeriesItem(seriesId)
            }

            override fun saveCallResult(data: List<SeriesItemResponse>) {
                lateinit var series: SeriesEntity
                for (response in data) {
                    if (response.id.toString() == seriesId) {
                        series = SeriesEntity(response.id.toString(),
                            response.name,
                            "https://image.tmdb.org/t/p/original"+response.posterPath,
                            response.overview,
                            response.originalLanguage,
                            response.firstAirDate,
                            response.voteAverage,
                        false)
                    }
                }
                localDataSource.updateSeries(series)
            }

            override fun createCall(): LiveData<ApiResponse<List<SeriesItemResponse>>> {
                return remoteDataSource.getSeries()
            }

        }.asLiveData()
    }

    override fun getBookmarkedMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedMovies(), config).build()
    }

    override fun getBookmarkedSeries(): LiveData<PagedList<SeriesEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedSeries(), config).build()
    }

    override fun setMovieBookmark(movieEntity: MovieEntity, state: Boolean) {
        return appExecutors.diskIO().execute { localDataSource.setMoviesBookmark(movieEntity, state) }
    }

    override fun setSeriesBookmark(seriesEntity: SeriesEntity, state: Boolean) {
        return appExecutors.diskIO().execute { localDataSource.setSeriesBookmark(seriesEntity, state) }
    }

}