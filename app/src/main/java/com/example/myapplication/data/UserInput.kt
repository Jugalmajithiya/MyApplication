package com.example.myapplication.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class UserInput(

    @SerializedName("from")
    val from: String?,



    @SerializedName("page")
    val page: Int?,

    @SerializedName("q")
    val q: String?,
    @SerializedName("ranked_only")
    val rankedOnly: String?,
    @SerializedName("search_in")
    val searchIn: List<String?>?,
    @SerializedName("size")
    val size: Int?,
    @SerializedName("sort_by")
    val sortBy: String?,

) : Parcelable