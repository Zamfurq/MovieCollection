package com.example.moviecollection.ui.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.entity.source.CollectionRepository
import com.example.moviecollection.vo.Resource


class SeriesViewModel(private val collectionRepository: CollectionRepository): ViewModel() {
    fun getSeries(sort: String): LiveData<Resource<PagedList<SeriesEntity>>> {
        return collectionRepository.getSeries(sort)
    }
}