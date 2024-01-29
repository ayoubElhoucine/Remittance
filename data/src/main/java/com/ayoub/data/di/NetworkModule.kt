package com.ayoub.data.di

import com.ayoub.data.network.api.RecipientApi
import com.ayoub.data.network.RemoteDataSource
import com.ayoub.data.network.api.CountryApi
import com.ayoub.data.network.api.WalletApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Singleton
    @Provides
    fun provideRecipientApi(
        remoteDataSource: RemoteDataSource,
    ): RecipientApi {
        return remoteDataSource.buildApi(RecipientApi::class.java)
    }

    @Singleton
    @Provides
    fun provideWalletApi(
        remoteDataSource: RemoteDataSource,
    ): WalletApi {
        return remoteDataSource.buildApi(WalletApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCountryApi(
        remoteDataSource: RemoteDataSource,
    ): CountryApi {
        return remoteDataSource.buildApi(CountryApi::class.java)
    }

}