package com.a.up.services

import com.a.up.user.model.AllUsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("users")
    suspend fun allArticles(
        @Query("page")
        page: Int
    ): Response<AllUsersResponse>
}