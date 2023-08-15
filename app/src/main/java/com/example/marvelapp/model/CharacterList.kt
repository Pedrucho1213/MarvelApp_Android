package com.example.marvelapp.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterList(
    @SerializedName(  "available") val available: Int?,
    @SerializedName( "returned") val returned: Int?,
    @SerializedName( "collectionURI") val collectionURI: String?,
    @SerializedName( "items") val items: List<CharacterSummary>?
)