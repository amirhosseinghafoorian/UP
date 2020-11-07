package com.a.up.home.data

import com.a.up.services.Api
import javax.inject.Inject

class HomeRemote @Inject
constructor(private val api: Api) {

    // here should be changed : the func should return Resource<AllUsersResponse>
    suspend fun fillAllUsersFromRemote(page: Int): MutableList<String> {
        val result = api.allArticles(page)
        val items = mutableListOf<String>()
        for (i in 0 until result.body()?.data?.size!!) {
            items.add(result.body()!!.data[i].first_name + " " + result.body()!!.data[i].last_name)
        }
        return items
    }

}