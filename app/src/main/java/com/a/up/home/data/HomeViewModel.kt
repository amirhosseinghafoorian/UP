package com.a.up.home.data

import androidx.lifecycle.ViewModel
import androidx.hilt.lifecycle.ViewModelInject



class HomeViewModel @ViewModelInject constructor(private val homeRepository: HomeRepository) : ViewModel(){

    fun fillFromViewModel() {
        homeRepository.fillFromRepository()
    }
}