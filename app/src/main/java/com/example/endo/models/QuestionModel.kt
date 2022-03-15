package com.example.endo.models

import kotlinx.serialization.Serializable

@Serializable
data class QuestionModel(
    private var id: Int,
    private val question: String
) {
}