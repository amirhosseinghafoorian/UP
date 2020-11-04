package com.a.up.home.data

import javax.inject.Inject

class HomeRepository @Inject constructor(private val remote: HomeRemote) {

    suspend fun fillFromRepository(): MutableList<String> {
        return remote.fillFromRemote()
    }
}