package com.example.network.models.pixabay

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageResult(
    @SerializedName("total") @Expose
     var total: Int? = null,
    @SerializedName("totalHits")
    @Expose
     val totalHits: Int? = null,

    @SerializedName("hits")
    @Expose
     val hits: List<Hit>? = null

)
