package com.example.network.repository

import com.example.core.utils.ResultWrapper
import com.example.network.api.TranslationApi
import javax.inject.Inject

class TranslationRepository @Inject constructor(
    private val translationApi: TranslationApi
) : ResultWrapper() {
    suspend fun getTranslate(wordInEnglish: String) =
        getResult { translationApi.searchTranslation(
             wordInEnglish = wordInEnglish
        ) }
}