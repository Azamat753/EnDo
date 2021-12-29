package com.example.network.models.pixabay

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class Hit(


    @Json(name = "id") @Expose
    private var id: Int? = null,
    @SerializedName("pageURL")
    @Expose
    private val pageURL: String? = null,

    @SerializedName("type")
    @Expose
    private val type: String? = null,

    @SerializedName("tags")
    @Expose
    private val tags: String? = null,

    @SerializedName("previewURL")
    @Expose
    private val previewURL: String? = null,

    @SerializedName("previewWidth")
    @Expose
    private val previewWidth: Int? = null,

    @SerializedName("previewHeight")
    @Expose
    private val previewHeight: Int? = null,

    @SerializedName("webformatURL")
    @Expose
    private val webformatURL: String? = null,

    @SerializedName("webformatWidth")
    @Expose
    private val webformatWidth: Int? = null,

    @SerializedName("webformatHeight")
    @Expose
    private val webformatHeight: Int? = null,

    @SerializedName("largeImageURL")
    @Expose
     val largeImageURL: String? = null,

    @SerializedName("imageWidth")
    @Expose
    private val imageWidth: Int? = null,

    @SerializedName("imageHeight")
    @Expose
    private val imageHeight: Int? = null,

    @SerializedName("imageSize")
    @Expose
    private val imageSize: Int? = null,

    @SerializedName("views")
    @Expose
    private val views: Int? = null,

    @SerializedName("downloads")
    @Expose
    private val downloads: Int? = null,

    @SerializedName("collections")
    @Expose
    private val collections: Int? = null,

    @SerializedName("likes")
    @Expose
    private val likes: Int? = null,

    @SerializedName("comments")
    @Expose
    private val comments: Int? = null,

    @SerializedName("user_id")
    @Expose
    private val userId: Int? = null,

    @SerializedName("user")
    @Expose
    private val user: String? = null,

    @SerializedName("userImageURL")
    @Expose
    private val userImageURL: String? = null
)