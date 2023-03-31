package com.example.myapplication.repo

import com.example.myapplication.network.ApiInterface
import okhttp3.MultipartBody
import java.nio.channels.spi.AbstractSelectionKey


class UserRepository(
    private val apiInterface: ApiInterface
) {

    suspend fun getNewsData(
        query: String,
        page: Int,
        key: String
    ) =
        apiInterface.getNewsRequest(query = query, page = page, key =key )


}