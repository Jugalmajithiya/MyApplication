package com.example.myapplication.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Article(
    @SerializedName("author")
    val author: String?,
    @SerializedName("authors")
    val authors: String?,
    @SerializedName("clean_url")
    val cleanUrl: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("excerpt")
    val excerpt: String?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("is_opinion")
    val isOpinion: Boolean?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("media")
    val media: String?,
    @SerializedName("published_date")
    val publishedDate: String?,
    @SerializedName("published_date_precision")
    val publishedDatePrecision: String?,
    @SerializedName("rank")
    val rank: Int?,
    @SerializedName("rights")
    val rights: String?,
    @SerializedName("_score")
    val score: Double?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("topic")
    val topic: String?,
    @SerializedName("twitter_account")
    val twitterAccount: String?
) : Parcelable