package com.example.network.models.antonyms

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AntonymsApiModel(
    @SerializedName("word")
    @Expose
    val word: String? = null,
    @SerializedName("antonyms")
    @Expose
    val antonyms: List<Any>? = null
)