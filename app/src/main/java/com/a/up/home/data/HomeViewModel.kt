package com.a.up.home.data

import androidx.lifecycle.ViewModel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData


class HomeViewModel @ViewModelInject constructor(private val homeRepository: HomeRepository) : ViewModel(){

    var userList = MutableLiveData<MutableList<String>>()

    suspend fun fillFromViewModel(page : Int) {
        userList.postValue(null)
        userList.postValue(homeRepository.fillFromRepository(page))
    }


}