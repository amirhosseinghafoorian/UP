package com.a.up.home.data

import javax.inject.Inject

class HomeRemote @Inject
constructor(private val retrofit: String) {

    suspend fun fillFromRemote(): MutableList<String> {
        val items = mutableListOf<String>()
        repeat(100) {
            items.add("user ")
        }
        return items
    }

}