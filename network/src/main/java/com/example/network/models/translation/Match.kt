package com.example.network.models.translation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Match(

    @SerializedName("id") @Expose
    var id: String? = null,
    @SerializedName("segment")
    @Expose
    var segment: String? = null,

    @SerializedName("translation")
    @Expose
    var translation: String? = null,

    @SerializedName("source")
    @Expose
    var source: String? = null,

    @SerializedName("target")
    @Expose
    var target: String? = null,

    @SerializedName("quality")
    @Expose
    var quality: String? = null,

    @SerializedName("reference")
    @Expose
    var reference: Any? = null,

    @SerializedName("usage-count")
    @Expose
    var usageCount: Int? = null,

    @SerializedName("subject")
    @Expose
    var subject: String? = null,

    @SerializedName("created-by")
    @Expose
    var createdBy: String? = null,

    @SerializedName("last-updated-by")
    @Expose
    var lastUpdatedBy: String? = null,

    @SerializedName("create-date")
    @Expose
    var createDate: String? = null,

    @SerializedName("last-update-date")
    @Expose
    var lastUpdateDate: String? = null,

    @SerializedName("match")
    @Expose
    var match: Double? = null

)