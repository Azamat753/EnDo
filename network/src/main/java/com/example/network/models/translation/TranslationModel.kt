package com.example.network.models.translation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TranslationModel(
    @SerializedName("responseData") @Expose
    var responseData: ResponseData? = null,

    @SerializedName("quotaFinished")
    @Expose
    var quotaFinished: Boolean? = null,

    @SerializedName("mtLangSupported")
    @Expose
    var mtLangSupported: Any? = null,

    @SerializedName("responseDetails")
    @Expose
    var responseDetails: String? = null,

    @SerializedName("responseStatus")
    @Expose
    var responseStatus: Int? = null,

    @SerializedName("responderId")
    @Expose
    var responderId: String? = null,

    @SerializedName("exception_code")
    @Expose
    var exceptionCode: Any? = null,

    @SerializedName("matches")
    @Expose
    var matches: List<Match>? = null

)