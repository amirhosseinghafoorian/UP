package com.a.up.home.data

import javax.inject.Inject

class HomeRepository @Inject constructor(private val remote: HomeRemote) {

    suspend fun fillFromRepository(page: Int): MutableList<String> {
        return remote.fillFromRemote(page)
    }
}