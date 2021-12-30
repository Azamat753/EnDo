package com.example.network.models.translation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("translatedText") @Expose
    var translatedText: String? = null,
    @SerializedName("match")
    @Expose
    var match: Double? = null

)