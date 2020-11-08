package com.a.up.home.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.a.up.PagingTest
import com.a.up.storage.Setting
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val remote: HomeRemote ,
    private val setting: Setting
    ) {

    suspend fun fillFromRepository(page: Int): Flow<String> {
        return remote.fillAllUsersFromRemote(page)
    }

    suspend fun pagedUsers(page : Int) : Flow<PagingData<String>> {
        return Pager(
            PagingConfig(pageSize = 6)
        ){
            PagingTest(remote)
        }.flow
    }

    fun getPrefString (key : String) : String{
        return setting.getString(key)
    }

    fun putPrefString (key : String , value : String) {
        setting.putString(key , value)
    }
}