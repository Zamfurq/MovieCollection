package com.example.moviecollection.injection

import android.content.Context
import com.example.moviecollection.entity.source.CollectionRepository
import com.example.moviecollection.entity.source.local.LocalDataSource
import com.example.moviecollection.entity.source.local.room.CollectionDatabase
import com.example.moviecollection.entity.source.remote.RemoteDataSource
import com.example.moviecollection.utility.AppExecutors

object Injection {
    fun provideRepository(context: Context) : CollectionRepository {
        val database = CollectionDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.collectionDao())
        val appExecutors = AppExecutors()

        return CollectionRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}