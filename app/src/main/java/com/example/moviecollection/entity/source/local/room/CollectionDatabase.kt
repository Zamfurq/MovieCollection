package com.example.moviecollection.entity.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.SeriesEntity

@Database(entities = [MovieEntity::class, SeriesEntity::class], version = 1, exportSchema = false)
abstract class CollectionDatabase : RoomDatabase() {
    abstract fun collectionDao(): CollectionDao

    companion object {
        @Volatile
        private var INSTANCE: CollectionDatabase? =null

        fun getInstance(context: Context): CollectionDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    CollectionDatabase::class.java,
                    "Collections.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}