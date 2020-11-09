package com.a.up.storage

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class SettingDataStore constructor(private val context: Context) {

    private val dataStore: DataStore<Preferences> by lazy {
        context.createDataStore(name = "locals_v2")
    }

    suspend fun putString(
        key: String,
        value: String
    ) {
        val myKey = preferencesKey<String>(key)
        dataStore.edit {
            it[myKey] = value
        }
    }

    fun getString(key: String): Flow<String> {
        return dataStore.data.catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            val myKey = preferencesKey<String>(key)
            it[myKey] ?: "***"
        }
    }

    suspend fun removeItem(key: String) {
        val myKey = preferencesKey<String>(key)
        dataStore.edit {
            it.remove(myKey)
        }
    }
}