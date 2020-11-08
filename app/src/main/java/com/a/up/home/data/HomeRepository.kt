package com.a.up.home.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.a.up.PagingTest
import com.a.up.storage.Setting
import com.a.up.user.model.Data
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val remote: HomeRemote,
    private val setting: Setting
) {

    fun pagedUsers(): Flow<PagingData<Data>> {
        return Pager(
            PagingConfig(
                pageSize = 6,
                maxSize = 15,
                prefetchDistance = 1
            )
        ) {
            PagingTest(remote)
        }.flow
    }

    fun getPrefString(key: String): String {
        return setting.getString(key)
    }

    fun putPrefString(key: String, value: String) {
        setting.putString(key, value)
    }
}