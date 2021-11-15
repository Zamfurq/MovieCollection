package com.example.moviecollection.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviecollection.entity.SeriesEntity
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
class SeriesFavoriteViewModelTest {
    private lateinit var viewModel: SeriesFavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var collectionRepository: CollectionRepository

    @Mock
    private lateinit var observer: Observer<PagedList<SeriesEntity>>

    @Mock
    private lateinit var pagedList: PagedList<SeriesEntity>

    @Before
    fun setUp() {
        viewModel = SeriesFavoriteViewModel(collectionRepository)
    }

    @Test
    fun getBookmarks() {
        val dummySeries = pagedList
        Mockito.`when`(dummySeries.size).thenReturn(10)
        val series = MutableLiveData<PagedList<SeriesEntity>>()
        series.value = dummySeries
        Mockito.`when`(collectionRepository.getBookmarkedSeries()).thenReturn(series)
        val seriesEntity = viewModel.getBookmarks().value
        Mockito.verify(collectionRepository).getBookmarkedSeries()
        Assert.assertNotNull(seriesEntity)
        Assert.assertEquals(10, seriesEntity?.size)
        Assert.assertNotEquals(15, seriesEntity?.size)

        viewModel.getBookmarks().observeForever(observer)
        Mockito.verify(observer).onChanged(dummySeries)
    }
}