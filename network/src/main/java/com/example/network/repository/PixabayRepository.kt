package com.example.network.repository

import com.example.core.ResultWrapper
import com.example.network.api.PixabayApi
import javax.inject.Inject

class PixabayRepository @Inject constructor(
    private val pixabayApi: PixabayApi
) : ResultWrapper() {
    suspend fun getImages(searchImage: String) =
        getResult {
            pixabayApi.searchForImage(searchQuery = searchImage)
        }
}