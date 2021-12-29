package com.example.network.api

import com.example.core.Constants
import com.example.network.models.pixabay.ImageResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searchQuery:String,
        @Query("key") apikey:String = Constants.PIXABAY_KEY
    ):Response<ImageResult>
}