package com.example.network.di

import com.example.core.utils.Constants
import com.example.network.api.AntonymsApi
import com.example.network.api.PixabayApi
import com.example.network.api.SynonymsApi
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

    @Provides
    @Singleton
    fun provideSynonymsApi() : SynonymsApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.SYNONYMS_BASE_URL).build().create(SynonymsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAntonymsApi() : AntonymsApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.ANTONYMS_BASE_URL).build().create(AntonymsApi::class.java)
    }
}