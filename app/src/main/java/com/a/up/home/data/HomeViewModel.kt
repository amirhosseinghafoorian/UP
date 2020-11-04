package com.a.up.home.data

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.up.home.domain.AllUsersUseCase

class HomeViewModel @ViewModelInject constructor(private val allUsersUseCase: AllUsersUseCase) :
    ViewModel() {

    var userList = MutableLiveData<MutableList<String>>()

    suspend fun fillFromViewModel(page: Int) {
        userList.postValue(null)
        userList.postValue(allUsersUseCase.fillFromUseCase(page))
    }

}