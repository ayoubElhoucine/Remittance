package com.ayoub.data.di

import com.ayoub.data.network.api.RecipientApi
import com.ayoub.data.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRecipientApi(
        remoteDataSource: RemoteDataSource,
    ): RecipientApi {
        return remoteDataSource.buildApi(RecipientApi::class.java)
    }

}