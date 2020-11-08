package com.a.up.home.domain

import com.a.up.home.data.HomeRepository
import javax.inject.Inject

class SharedPrefUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    fun getPrefString(
        key: String
    ): String {
        return homeRepository.getPrefString(key)
    }

    fun putPrefString(
        key: String,
        value: String
    ) {
        homeRepository.putPrefString(key, value)
    }

    fun removePrefString(
        key: String
    ) {
        homeRepository.removePrefString(key)
    }

}