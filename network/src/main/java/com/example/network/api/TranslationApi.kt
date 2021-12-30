package com.example.network.api

import com.example.network.BuildConfig
import com.example.network.models.translation.TranslationModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TranslationApi {

    @GET("/api/get")
    suspend fun searchTranslation(
        @Query("langpair") langPair:String="en|ru",
        @Query("q") wordInEnglish:String,
        @Query("mt") mt:Int = 1,
        @Query("onlyprivate") onlyPrivate:Int = 0,
        @Query("de") de:String = "a@b.c",
        @Header("x-rapidapi-host") header1:String = "translated-mymemory---translation-memory.p.rapidapi.com",
        @Header("x-rapidapi-key") header2:String = BuildConfig.TRANSLATION_KEY,
    ):Response<TranslationModel>
}