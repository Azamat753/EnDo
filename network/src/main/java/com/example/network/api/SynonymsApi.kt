package com.example.network.api

import com.example.network.models.synonyms.SynonymsApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface SynonymsApi {
    @GET
    suspend fun searchSynonyms(
        @Url url: String,
        @Query("synonyms") synonymsInEnglish: String
    ): Response<SynonymsApiModel>
}