package com.a.up.home.domain

import com.a.up.home.data.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class AllUsersUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend fun fillFromUseCase(page: Int): Flow<String> {
        return homeRepository.fillFromRepository(page)
    }

    companion object {
        fun send(): Flow<String> {
            return flowOf("one", "two", "three")
        }
    }
}