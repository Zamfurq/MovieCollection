package com.example.moviecollection.utility

import com.example.moviecollection.entity.source.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("list/{id}")
    fun getMovieList(
        @Path("id") id : String,
        @Query("api_key") apiKey : String
    ): Call<MovieResponse>

    @GET("list/{id}")
    fun getSeriesList(
        @Path("id") id : String,
        @Query("api_key") apiKey : String
    ): Call<SeriesResponse>

}