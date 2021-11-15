package com.example.moviecollection.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.entity.source.CollectionRepository

class SeriesFavoriteViewModel(private val collectionRepository: CollectionRepository): ViewModel(){
    fun getBookmarks(): LiveData<PagedList<SeriesEntity>> {
        return collectionRepository.getBookmarkedSeries()
    }

    fun setBookmark(seriesEntity: SeriesEntity) {
        val newState = !seriesEntity.bookmarked
        collectionRepository.setSeriesBookmark(seriesEntity, newState)
    }
}