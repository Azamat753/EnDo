package com.example.db.models

data class QuestionModel(
    val audio: Int,
    val question: String,
    val firstAnswer: String,
    val secondAnswer: String,
    val thirdAnswer: String,
    val fourthAnswer: String,
    val correctAnswer: String,
)
