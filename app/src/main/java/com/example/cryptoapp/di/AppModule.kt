package com.example.cryptoapp.di

import com.example.cryptoapp.common.Constants
import com.example.cryptoapp.data.remote.CryptoApi
import com.example.cryptoapp.data.repository.CoinRepositoryImpl
import com.example.cryptoapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideCryptoApi(retrofit: Retrofit) = retrofit.create(CryptoApi::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(api: CryptoApi):CoinRepository = CoinRepositoryImpl(api)
}