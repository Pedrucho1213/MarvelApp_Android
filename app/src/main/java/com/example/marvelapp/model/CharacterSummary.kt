package com.example.marvelapp.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterSummary(
    @SerializedName(  "resourceURI") val resourceURI: String?,
    @SerializedName(  "name") val name: String?,
    @SerializedName(  "role") val role: String?
)