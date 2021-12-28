package com.example.network

import com.example.network.models.ImageResult
import retrofit2.Response
import javax.inject.Inject

class PixabayRepository @Inject constructor(
    private val pixabayApi: PixabayApi
) : ResultWrapper() {
    suspend fun getImages(searchImage: String) =
        getResult {
            pixabayApi.searchForImage(searchQuery = searchImage)
        }
}