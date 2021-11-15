package com.example.moviecollection.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviecollection.dummy.DataDummy
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.source.CollectionRepository
import com.example.moviecollection.utility.SortUtils
import com.example.moviecollection.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var collectionRepository: CollectionRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(collectionRepository)
    }

    @Test
    fun getMovies() {
        val sort = SortUtils.DEFAULT
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(10)
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovies
        `when`(collectionRepository.getMovies(sort)).thenReturn(movies)
        val movieEntity = viewModel.getMovies(sort).value?.data
        verify(collectionRepository).getMovies(sort)
        assertNotNull(movieEntity)
        assertEquals(10, movieEntity?.size)
        assertNotEquals(15, movieEntity?.size)
        viewModel.getMovies(sort).observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }


}