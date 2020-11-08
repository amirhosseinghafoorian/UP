package com.a.up.home.domain

import androidx.paging.PagingData
import com.a.up.home.data.HomeRepository
import com.a.up.user.model.Data
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AllUsersUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    fun pagedUsers(): Flow<PagingData<Data>> {
        return homeRepository.pagedUsers()
    }

}