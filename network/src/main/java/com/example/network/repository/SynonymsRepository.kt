package com.example.network.repository

import com.example.core.utils.ResultWrapper
import com.example.network.api.SynonymsApi
import javax.inject.Inject

class SynonymsRepository @Inject constructor(
    private val synonymsApi : SynonymsApi
) :ResultWrapper(){
    suspend fun getSynonyms(synonymsInEnglish: String) =
        getResult {
            synonymsApi.searchSynonyms("https://wordsapiv1.p.mashape.com/words/lovely/synonyms",synonymsInEnglish = synonymsInEnglish)
        }
}