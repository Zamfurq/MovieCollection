package com.example.moviecollection.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecollection.dummy.DataDummy
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.entity.source.CollectionRepository
import com.example.moviecollection.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailSeriesViewModelTest {
    private lateinit var viewModel: DetailSeriesViewModel
    private val dummySeries = Resource.success(DataDummy.generateSeries()[0])
    private val seriesId = dummySeries.data?.seriesId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var collectionRepository: CollectionRepository

    @Mock
    private lateinit var observer: Observer<Resource<SeriesEntity>>

    @Before
    fun setUp() {
        viewModel = DetailSeriesViewModel(collectionRepository)
        if (seriesId != null) {
            viewModel.setSelectedSeries(seriesId)
        }
    }

    @Test
    fun getSeries() {
        val series = MutableLiveData<Resource<SeriesEntity>>()
        series.value = dummySeries
        `when`(seriesId?.let { collectionRepository.getSeriesItem(it) }).thenReturn(series)
        viewModel.series.observeForever(observer)
        verify(observer).onChanged(dummySeries)
    }

}