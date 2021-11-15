package com.example.moviecollection.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecollection.dummy.DataDummy
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.source.CollectionRepository
import com.example.moviecollection.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var detailMovieViewModel: DetailMovieViewModel
    private val dummyMovie = Resource.success(DataDummy.generateMovies()[0])
    private val movieId = dummyMovie.data?.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var collectionRepository: CollectionRepository

    @Mock
    private lateinit var observer: Observer<Resource<MovieEntity>>

    @Before
    fun setUp() {
        detailMovieViewModel = DetailMovieViewModel(collectionRepository)
        if (movieId != null) {
            detailMovieViewModel.setSelectedMovie(movieId)
        }
    }

    @Test
    fun getMovies() {
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie
        `when`(movieId?.let { collectionRepository.getMoviesItem(it) }).thenReturn(movie)

        detailMovieViewModel.movies.observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

}