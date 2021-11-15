package com.example.moviecollection.ui.tvseries

import com.example.moviecollection.entity.SeriesEntity

interface SeriesCallback {
    fun onShareClick(series: SeriesEntity)
}