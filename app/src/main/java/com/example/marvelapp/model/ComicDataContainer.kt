package com.example.marvelapp.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ComicDataContainer(
    @SerializedName("offset") val moffset: Int?,
    @SerializedName("limit") val mlimit: Int?,
    @SerializedName("total") val mtotal: Int?,
    @SerializedName("count") val mcount: Int?,
    @SerializedName("results") val mresults: List<Comic>?
) {
}