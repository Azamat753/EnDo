package com.example.network.models.synonyms

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SynonymsApiModel(
    @SerializedName("word")
    @Expose
    var word: String? = null,
    @SerializedName("synonyms")
    @Expose
    var synonyms: List<String>? = null
)