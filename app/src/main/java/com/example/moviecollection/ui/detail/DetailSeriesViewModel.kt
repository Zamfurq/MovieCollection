package com.example.moviecollection.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.entity.source.CollectionRepository
import com.example.moviecollection.vo.Resource

class DetailSeriesViewModel(private val collectionRepository: CollectionRepository): ViewModel() {
    var seriesId= MutableLiveData<String>()

    fun setSelectedSeries(seriesId: String) {
        this.seriesId.value = seriesId
    }

    var series: LiveData<Resource<SeriesEntity>> = Transformations.switchMap(seriesId) {mSeriesId ->
        collectionRepository.getSeriesItem(mSeriesId)
    }

    fun setBookmark() {
        val seriesResource = series.value
        if (seriesResource != null) {
            val seriesEntity = seriesResource.data
            if (seriesEntity != null) {
                val newState = !seriesEntity.bookmarked
                collectionRepository.setSeriesBookmark(seriesEntity, newState)
            }
        }
    }

}