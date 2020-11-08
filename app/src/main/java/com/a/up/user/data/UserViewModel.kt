package com.a.up.user.data

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.up.core.resource.Resource
import com.a.up.home.domain.SharedPrefUseCase
import com.a.up.user.domain.LoginUseCase
import com.a.up.user.model.LoginResponse

class UserViewModel
@ViewModelInject constructor(
    private val loginUseCase: LoginUseCase,
    private val sharedPrefUseCase: SharedPrefUseCase
) : ViewModel() {

    var loginResult = MutableLiveData<Resource<LoginResponse>>()

    suspend fun login(username: String, password: String) {
        loginResult.postValue(Resource.loading(null))
        loginResult.postValue(loginUseCase.login("eve.holt@reqres.in", "cityslicka"))
    }

    fun putPrefString(
        key: String,
        value: String
    ) {
        sharedPrefUseCase.putPrefString(key, value)
    }

    fun removePrefString(
        key: String
    ) {
        sharedPrefUseCase.removePrefString(key)
    }
}