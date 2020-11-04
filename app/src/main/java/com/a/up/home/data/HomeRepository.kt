package com.a.up.home.data

import javax.inject.Inject

class HomeRepository @Inject constructor(private val remote: HomeRemote) {

    fun fillFromRepository() {
        remote.fillFromRemote()
    }
}