package com.a.up.user.data

import com.a.up.core.resource.Resource
import com.a.up.core.safeApiCall
import com.a.up.services.Api
import com.a.up.user.model.LoginRequest
import com.a.up.user.model.LoginResponse
import javax.inject.Inject

class UserRemote @Inject
constructor(private val api: Api) {

    suspend fun loginFromRemote(username: String, password: String): Resource<LoginResponse> {
        return safeApiCall {
            api.login(
                LoginRequest(
                    username,
                    password
                )
            )
        }
    }

}