package com.a.up.user.data

import com.a.up.core.resource.Resource
import com.a.up.user.model.LoginResponse
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remote: UserRemote
) {

    suspend fun loginFromRepository(username: String, password: String): Resource<LoginResponse> {
        return remote.loginFromRemote(username, password)
    }
}