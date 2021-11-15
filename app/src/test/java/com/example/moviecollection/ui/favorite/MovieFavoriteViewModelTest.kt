package com.example.moviecollection.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.source.CollectionRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieFavoriteViewModelTest {
    private lateinit var viewModel: MovieFavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var collectionRepository: CollectionRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MovieFavoriteViewModel(collectionRepository)
    }

    @Test
    fun getBookmarks() {
        val dummyMovies = pagedList
        Mockito.`when`(dummyMovies.size).thenReturn(10)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovies
        Mockito.`when`(collectionRepository.getBookmarkedMovies()).thenReturn(movies)
        val movieEntity = viewModel.getBookmarks().value
        Mockito.verify(collectionRepository).getBookmarkedMovies()
        Assert.assertNotNull(movieEntity)
        Assert.assertEquals(10, movieEntity?.size)
        Assert.assertNotEquals(15, movieEntity?.size)
        viewModel.getBookmarks().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }
}