package com.a.up.home.data

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

    fun getPrefString (key : String) : String{
        return setting.getString(key)
    }

    fun putPrefString (key : String , value : String) {
        setting.putString(key , value)
    }
}