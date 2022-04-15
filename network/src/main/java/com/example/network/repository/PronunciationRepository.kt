package com.example.network.repository

import com.example.network.client.PronunciationClient
import javax.inject.Inject

class PronunciationRepository @Inject constructor(
    private val client: PronunciationClient.Companion
) {

    fun getPronunciations() = client.getList()
}