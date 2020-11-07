package com.a.up.home.data

import com.a.up.storage.Setting
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val remote: HomeRemote ,
    private val setting: Setting
    ) {

    suspend fun fillFromRepository(page: Int): MutableList<String> {
        return remote.fillFromRemote(page)
    }

    fun getPrefString (key : String) : String{
        return setting.getString(key)
    }

    fun putPrefString (key : String , value : String) {
        setting.putString(key , value)
    }
}