package com.example.network.di

import com.example.core.utils.Constants
import com.example.network.api.PixabayApi
import com.example.network.api.TranslationApi
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
            .baseUrl(Constants.PIXABAY_BASE_URL).build().create(PixabayApi::class.java)
    }
    @Singleton
    @Provides
    fun provideTranslationApi(): TranslationApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.TRANSLATION_BASE_URL).build().create(TranslationApi::class.java)
    }
}