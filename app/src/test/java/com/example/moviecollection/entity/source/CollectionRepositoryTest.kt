package com.example.moviecollection.entity.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.moviecollection.dummy.DataDummy
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.PagedListUtils
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.entity.source.local.LocalDataSource
import com.example.moviecollection.entity.source.remote.RemoteDataSource
import com.example.moviecollection.utility.AppExecutors
import com.example.moviecollection.utility.LiveDataTestUtils
import com.example.moviecollection.utility.SortUtils
import com.example.moviecollection.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class CollectionRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val collectionRepository = FakeCollectionRepository(remote, local, appExecutors)

    private val movieItemResponse = DataDummy.generateRemoteMovies()
    private val movieId = movieItemResponse[0].id
    private val seriesItemResponse = DataDummy.generateRemoteSeries()
    private val seriesId = seriesItemResponse[0].id

    @Test
    fun getMovies() {
        val sort = SortUtils.DEFAULT
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int,MovieEntity>
        `when`(local.getAllMovies(sort)).thenReturn(dataSourceFactory)
        collectionRepository.getMovies(sort)

        val movieEntity = Resource.success(PagedListUtils.mockPagedList(DataDummy.generateMovies()))
        verify(local).getAllMovies(sort)
        assertNotNull(movieEntity.data)
        assertEquals(movieItemResponse.size.toLong(), movieEntity.data?.size?.toLong())
        assertNotEquals(15, movieEntity.data?.size?.toLong())
    }

    @Test
    fun getBookmarkMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int,MovieEntity>
        `when`(local.getBookmarkedMovies()).thenReturn(dataSourceFactory)
        collectionRepository.getBookmarkedMovies()

        val movieEntity = Resource.success(PagedListUtils.mockPagedList(DataDummy.generateMovies()))
        verify(local).getBookmarkedMovies()
        assertNotNull(movieEntity.data)
        assertEquals(movieItemResponse.size.toLong(), movieEntity.data?.size?.toLong())
        assertNotEquals(15, movieEntity.data?.size?.toLong())
    }

    @Test
    fun getSeries() {
        val sort = SortUtils.DEFAULT
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int,SeriesEntity>
        `when`(local.getAllSeries(sort)).thenReturn(dataSourceFactory)
        collectionRepository.getSeries(sort)

        val seriesEntity = Resource.success(PagedListUtils.mockPagedList(DataDummy.generateSeries()))
        verify(local).getAllSeries(sort)
        assertNotNull(seriesEntity.data)
        assertEquals(seriesItemResponse.size.toLong(), seriesEntity.data?.size?.toLong())
        assertNotEquals(15, seriesEntity.data?.size?.toLong())
    }

    @Test
    fun getBookmarkSeries() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int,SeriesEntity>
        `when`(local.getBookmarkedSeries()).thenReturn(dataSourceFactory)
        collectionRepository.getBookmarkedSeries()

        val seriesEntity = Resource.success(PagedListUtils.mockPagedList(DataDummy.generateSeries()))
        verify(local).getBookmarkedSeries()
        assertNotNull(seriesEntity.data)
        assertEquals(seriesItemResponse.size.toLong(), seriesEntity.data?.size?.toLong())
        assertNotEquals(15, seriesEntity.data?.size?.toLong())
    }

    @Test
    fun getMoviesItem() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = DataDummy.generateMovies()[0]
        `when`(local.getMoviesItem(movieId.toString())).thenReturn(dummyMovie)
        val movieItem = LiveDataTestUtils.getValue(collectionRepository.getMoviesItem(movieId.toString()))
        verify(local).getMoviesItem(movieId.toString())
        assertNotNull(movieItem)
        assertNotNull(movieItem.data)
        assertEquals(movieItemResponse[0].title, movieItem.data?.title)
        assertEquals(movieItemResponse[0].posterPath, movieItem.data?.poster)
        assertEquals(movieItemResponse[0].overview, movieItem.data?.synopsis)
        assertEquals(movieItemResponse[0].originalLanguage, movieItem.data?.originLanguage)
        assertEquals(movieItemResponse[0].releaseDate, movieItem.data?.releaseYear)
        assertEquals(movieItemResponse[0].voteAverage, movieItem.data?.voteCount)
        assertNotEquals(null, movieItem.data?.title)
        assertNotEquals(null, movieItem.data?.poster)
        assertNotEquals(null, movieItem.data?.synopsis)
        assertNotEquals(null, movieItem.data?.originLanguage)
        assertNotEquals(null, movieItem.data?.releaseYear)
        assertNotEquals(null, movieItem.data?.voteCount)

    }

    @Test
    fun getSeriesItem() {
        val dummySeries = MutableLiveData<SeriesEntity>()
        dummySeries.value = DataDummy.generateSeries()[0]
        `when`(local.getSeriesItem(seriesId.toString())).thenReturn(dummySeries)
        val seriesItem = LiveDataTestUtils.getValue(collectionRepository.getSeriesItem(seriesId.toString()))
        verify(local).getSeriesItem(seriesId.toString())
        assertNotNull(seriesItem)
        assertNotNull(seriesItem.data)
        assertEquals(seriesItemResponse[0].name, seriesItem.data?.title)
        assertEquals(seriesItemResponse[0].posterPath, seriesItem.data?.poster)
        assertEquals(seriesItemResponse[0].overview, seriesItem.data?.synopsis)
        assertEquals(seriesItemResponse[0].originalLanguage, seriesItem.data?.originLanguage)
        assertEquals(seriesItemResponse[0].firstAirDate, seriesItem.data?.firstEpisodeYear)
        assertEquals(seriesItemResponse[0].voteAverage, seriesItem.data?.voteCount)
        assertNotEquals(null, seriesItem.data?.title)
        assertNotEquals(null, seriesItem.data?.poster)
        assertNotEquals(null, seriesItem.data?.synopsis)
        assertNotEquals(null, seriesItem.data?.originLanguage)
        assertNotEquals(null, seriesItem.data?.firstEpisodeYear)
        assertNotEquals(null, seriesItem.data?.voteCount)
    }
}