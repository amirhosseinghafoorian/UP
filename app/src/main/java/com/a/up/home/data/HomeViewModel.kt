package com.a.up.home.data

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.a.up.home.domain.AllUsersUseCase
import com.a.up.home.domain.SharedPrefUseCase
import kotlinx.coroutines.flow.Flow

class HomeViewModel @ViewModelInject constructor(
    private val allUsersUseCase: AllUsersUseCase,
    private val sharedPrefUseCase: SharedPrefUseCase
) :
    ViewModel() {

//    var userList = MutableLiveData<MutableList<String>>()

//    suspend fun fillFromViewModel(page: Int) {
//        userList.postValue(null)
//        userList.postValue(allUsersUseCase.fillFromUseCase(page))
//    }

    fun pagedUsers() = allUsersUseCase.pagedUsers()

    fun getPrefString(key: String): Flow<String> {
        return sharedPrefUseCase.getPrefString(key)
    }

}