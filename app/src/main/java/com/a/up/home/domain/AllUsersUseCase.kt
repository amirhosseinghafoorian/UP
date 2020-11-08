package com.a.up.home.domain

import androidx.paging.PagingData
import com.a.up.home.data.HomeRepository
import com.a.up.user.model.Data
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class AllUsersUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    fun pagedUsers(): Flow<PagingData<Data>> {
        return homeRepository.pagedUsers()
    }

    companion object {
        fun send(): Flow<String> {
            return flowOf("one", "two", "three")
        }
    }
}