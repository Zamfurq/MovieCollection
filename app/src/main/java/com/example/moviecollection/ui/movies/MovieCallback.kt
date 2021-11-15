package com.example.moviecollection.ui.movies

import com.example.moviecollection.entity.MovieEntity

interface MovieCallback {
    fun onShareClick(movie: MovieEntity)
}
