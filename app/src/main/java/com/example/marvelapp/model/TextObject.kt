package com.example.marvelapp.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TextObject(
    @SerializedName("type") val type: String?,
    @SerializedName("language") val language: String?,
    @SerializedName("text") val text: String?
)