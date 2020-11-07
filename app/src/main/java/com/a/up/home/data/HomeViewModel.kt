package com.a.up.home.data

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.up.home.domain.AllUsersUseCase
import com.a.up.home.domain.SharedPrefUseCase

class HomeViewModel @ViewModelInject constructor(
    private val allUsersUseCase: AllUsersUseCase ,
    private val sharedPrefUsecase: SharedPrefUseCase ) :
    ViewModel() {

    var userList = MutableLiveData<MutableList<String>>()

    suspend fun fillFromViewModel(page: Int) {
        userList.postValue(null)
        userList.postValue(allUsersUseCase.fillFromUseCase(page))
    }

    fun getPrefString (key : String) : String{
        return sharedPrefUsecase.getPrefString(key)
    }

    fun putPrefString (key : String , value : String) {
        sharedPrefUsecase.putPrefString(key , value)
    }

}