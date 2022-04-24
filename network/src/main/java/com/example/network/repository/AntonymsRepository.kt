 package com.example.network.repository

import com.example.core.utils.ResultWrapper
import com.example.network.api.AntonymsApi
import javax.inject.Inject

class AntonymsRepository @Inject constructor(
    private val antonymsApi: AntonymsApi
) : ResultWrapper(){
    suspend fun getAntonyms(antonymsInEnglish: String) =
        getResult {
            antonymsApi.searchAntonyms("https://wordsapiv1.p.mashape.com/words/dog/antonyms",antonymsInEnglish = antonymsInEnglish)
        }
}