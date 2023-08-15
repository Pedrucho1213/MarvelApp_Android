package com.example.marvelapp.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ComicPrice(
    @SerializedName("type") val type: String?,
    @SerializedName("price") val price: Float?
)