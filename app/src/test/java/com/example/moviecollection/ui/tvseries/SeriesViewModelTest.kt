package com.example.moviecollection.ui.tvseries

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviecollection.dummy.DataDummy
import com.example.moviecollection.entity.SeriesEntity
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
class SeriesViewModelTest {
    private lateinit var viewModel: SeriesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var collectionRepository: CollectionRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<SeriesEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<SeriesEntity>

    @Before
    fun setUp() {
        viewModel = SeriesViewModel(collectionRepository)
    }

    @Test
    fun getSeries() {
        val sort = SortUtils.DEFAULT
        val dummySeries = Resource.success(pagedList)
        `when`(dummySeries.data?.size).thenReturn(10)
        val series = MutableLiveData<Resource<PagedList<SeriesEntity>>>()
        series.value = dummySeries
        `when`(collectionRepository.getSeries(sort)).thenReturn(series)
        val seriesEntity = viewModel.getSeries(sort).value?.data
        verify(collectionRepository).getSeries(sort)
        assertNotNull(seriesEntity)
        assertEquals(10, seriesEntity?.size)
        assertNotEquals(15, seriesEntity?.size)

        viewModel.getSeries(sort).observeForever(observer)
        verify(observer).onChanged(dummySeries)
    }

}