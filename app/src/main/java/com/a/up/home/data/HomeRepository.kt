package com.a.up.home.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.a.up.general.MyPagingSource
import com.a.up.storage.Setting
import com.a.up.storage.SettingDataStore
import com.a.up.user.model.Data
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val remote: HomeRemote,
    private val setting: Setting,
    private val dataStore: SettingDataStore
) {

    fun pagedUsers(): Flow<PagingData<Data>> {
        return Pager(
            PagingConfig(
                pageSize = 6,
                maxSize = 15,
                prefetchDistance = 1
            )
        ) {
            MyPagingSource(remote)
        }.flow
    }

    fun getPrefString(key: String): Flow<String> {
        return dataStore.getString(key)
    }

    suspend fun putPrefString(
        key: String,
        value: String
    ) {
        dataStore.putString(key, value)
    }

    suspend fun removePrefString(
        key: String
    ) {
        dataStore.removeItem(key)
    }


}