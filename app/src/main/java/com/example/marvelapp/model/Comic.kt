package com.example.marvelapp.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Comic(
    @SerializedName("id") val mid: Int?,
    @SerializedName("digitalId") val mdigitalId: Int?,
    @SerializedName("title") val mtitle: String?,
    @SerializedName("issueNumber") val missueNumber: Double?,
    @SerializedName("variantDescription") val mvariantDescription: String?,
    @SerializedName("description") val mdescription: String?,
    @SerializedName("modified") val mmodified: Date?,
    @SerializedName("isbn") val misbn: String?,
    @SerializedName("upc") val mupc: String?,
    @SerializedName("diamondCode") val mdiamondCode: String?,
    @SerializedName("ean") val mean: String?,
    @SerializedName("issn") val missn: String?,
    @SerializedName("format") val mformat: String?,
    @SerializedName("pageCount") val mpageCount: Int?,
    @SerializedName("textObjects") val mtextObjects: List<TextObject>?,
    @SerializedName("resourceURI") val mresourceURI: String?,
    @SerializedName("urls") val murls: List<Url>?,
    @SerializedName("series") val mseries: SeriesSummary?,
    @SerializedName("variants") val mvariants: List<ComicSummary>?,
    @SerializedName("collections") val collections: List<ComicSummary>?,
    @SerializedName("collectedIssues") val collectedIssues: List<ComicSummary>?,
    @SerializedName("dates") val dates: List<ComicDate>?,
    @SerializedName("prices") val prices: List<ComicPrice>?,
    @SerializedName("thumbnail") val thumbnail: Image?,
    @SerializedName("images") val images: List<Image>?,
    @SerializedName("creators") val creators: CreatorList?,
    @SerializedName("characters") val characters: CharacterList?,
    @SerializedName("stories") val stories: StoryList?,
    @SerializedName("events") val events: EventList?
)