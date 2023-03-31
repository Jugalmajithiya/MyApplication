package com.example.myapplication.network

import com.example.myapplication.data.NewsDataResponse
import com.example.myapplication.utils.Constant
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*


interface ApiInterface {


    @GET(Constant.NEWS_ENDPOINT)
    suspend fun getNewsRequest(
        @Header("x-api-key") key:String,
        @Query("q") query: String,
        @Query("page") page: Int
    ): Response<NewsDataResponse>
//


}