package com.example.network.di

import com.example.core.Constants
import com.example.network.PixabayApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providePixabayApi(): PixabayApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL).build().create(PixabayApi::class.java)
    }
}