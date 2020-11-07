package com.a.up.services

import com.a.up.user.model.AllUsersResponse
import com.a.up.user.model.LoginRequest
import com.a.up.user.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @GET("users")
    suspend fun allArticles(
        @Query("page")
        page: Int
    ): Response<AllUsersResponse>

    @POST("login")
    suspend fun login(@Body authRequest: LoginRequest): Response<LoginResponse>
}