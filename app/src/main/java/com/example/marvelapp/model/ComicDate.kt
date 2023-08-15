package com.example.marvelapp.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class ComicDate(
    @SerializedName("type") val type: String?,
    @SerializedName("date") val date: Date?
)