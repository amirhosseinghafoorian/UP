package com.a.up.home.data

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class HomeViewModel @ViewModelInject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {

    var userList = MutableLiveData<MutableList<String>>()

    suspend fun fillFromViewModel(page: Int) {
        userList.postValue(null)
        userList.postValue(homeRepository.fillFromRepository(page))
    }


}