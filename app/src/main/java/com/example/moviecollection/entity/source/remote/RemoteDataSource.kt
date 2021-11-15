package com.example.moviecollection.entity.source.remote

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecollection.BuildConfig
import com.example.moviecollection.entity.source.remote.response.MovieItemResponse
import com.example.moviecollection.entity.source.remote.response.MovieResponse
import com.example.moviecollection.entity.source.remote.response.SeriesItemResponse
import com.example.moviecollection.entity.source.remote.response.SeriesResponse
import com.example.moviecollection.utility.ApiConfig
import com.example.moviecollection.utility.EspressoIdlingResources
import retrofit2.Call
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }
    fun getMovies(): LiveData<ApiResponse<List<MovieItemResponse>>> {
        EspressoIdlingResources.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieItemResponse>>>()
        val client = ApiConfig.getApiService().getMovieList("7097456", BuildConfig.API_KEY)
        client.enqueue(object : retrofit2.Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.body() != null) {
                    Log.d(TAG,response.body().toString())
                    resultMovie.value = ApiResponse.success(response.body()!!.results)
                }
                else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
        EspressoIdlingResources.decrement()
        return resultMovie
    }

    fun getSeries(): LiveData<ApiResponse<List<SeriesItemResponse>>> {
        EspressoIdlingResources.increment()
        val resultSeries = MutableLiveData<ApiResponse<List<SeriesItemResponse>>>()
        val client = ApiConfig.getApiService().getSeriesList("7097457", BuildConfig.API_KEY)
        client.enqueue(object : retrofit2.Callback<SeriesResponse> {
            override fun onResponse(
                call: Call<SeriesResponse>,
                response: Response<SeriesResponse>
            ) {
                resultSeries.value = ApiResponse.success(response.body()!!.results)
            }

            override fun onFailure(call: Call<SeriesResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
        EspressoIdlingResources.decrement()
        return resultSeries
    }

    interface LoadMoviesCallback {
        fun onAllMovieReceived(movieItemResponse: List<MovieItemResponse>)
    }

    interface LoadSeriesCallback {
        fun onAllSeriesReceived(seriesItemResponse: List<SeriesItemResponse>)
    }

}