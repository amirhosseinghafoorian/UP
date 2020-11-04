package com.a.up.home.domain

import com.a.up.home.data.HomeRepository
import javax.inject.Inject

class AllUsersUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend fun fillFromUseCase(page: Int): MutableList<String> {
        return homeRepository.fillFromRepository(page)
    }
}