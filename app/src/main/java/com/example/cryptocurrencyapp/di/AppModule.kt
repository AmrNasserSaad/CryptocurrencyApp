package com.example.cryptocurrencyapp.di

import com.example.cryptocurrencyapp.common.Constants.BASE_URL
import com.example.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module // tell him this about dagger hilt
@InstallIn(SingletonComponent::class) // means this module will live as long as app live
object AppModule {

    @Provides // to provide something (dependence)
    @Singleton // create one single instance whenever we call it
    fun providePaprikaApi(): CoinPaprikaApi {
        // this api fun not depends on thing it just return Retrofit instance
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides // to provide something (dependence)
    @Singleton // create one single instance whenever we call it
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        // this  repo  fun  depends on api and returns Repository
        return CoinRepositoryImpl(api)
    }

}