package com.example.myapplication.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class NewsDataResponse(
    @SerializedName("articles")
    val articles: ArrayList<Article>?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("page_size")
    val pageSize: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("total_hits")
    val totalHits: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("user_input")
    val userInput: UserInput?
) : Parcelable