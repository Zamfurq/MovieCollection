package com.example.moviecollection.entity.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("results")
	val results: List<MovieItemResponse>
)

