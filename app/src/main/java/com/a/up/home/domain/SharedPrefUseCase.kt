package com.a.up.home.domain

import com.a.up.home.data.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SharedPrefUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    fun getPrefString(
        key: String
    ): Flow<String> {
        return homeRepository.getPrefString(key)
    }

    suspend fun putPrefString(
        key: String,
        value: String
    ) {
        homeRepository.putPrefString(key, value)
    }

    suspend fun removePrefString(
        key: String
    ) {
        homeRepository.removePrefString(key)
    }

}