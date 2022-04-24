package com.example.network.api

import com.example.network.models.antonyms.AntonymsApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface AntonymsApi{
    @GET suspend fun searchAntonyms(
    @Url url: String,
    @Query("antonyms") antonymsInEnglish: String
): Response<AntonymsApiModel>
}
