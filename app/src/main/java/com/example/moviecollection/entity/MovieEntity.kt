package com.example.moviecollection.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "poster")
    var poster: String,

    @ColumnInfo(name = "synopsis")
    var synopsis: String,

    @ColumnInfo(name = "originLanguage")
    var originLanguage: String,

    @ColumnInfo(name = "releaseYear")
    var releaseYear: String,

    @ColumnInfo(name = "voteCount")
    var voteCount: Double,

    @ColumnInfo(name = "bookmarked")
    var bookmarked: Boolean
)