package com.a.up.user.domain

import com.a.up.core.resource.Resource
import com.a.up.user.data.UserRepository
import com.a.up.user.model.LoginResponse
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun login(username: String, password: String): Resource<LoginResponse> {
        return userRepository.loginFromRepository(username, password)
    }
}