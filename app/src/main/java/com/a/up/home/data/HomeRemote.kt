package com.a.up.home.data

import com.a.up.services.Api
import com.a.up.user.model.AllUsersResponse
import retrofit2.Response
import javax.inject.Inject

class HomeRemote @Inject
constructor(private val api: Api) {

    suspend fun fillAllUsersFromRemote(page: Int): Response<AllUsersResponse> {
        return api.allUsersList(page)
    }

}