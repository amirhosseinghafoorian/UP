package com.a.up.general

import androidx.paging.PagingSource
import com.a.up.home.data.HomeRemote
import com.a.up.user.model.Data

class MyPagingSource(
    private val backend: HomeRemote,

    ) : PagingSource<Int, Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = backend.fillAllUsersFromRemote(nextPageNumber).body()
            LoadResult.Page(
                data = response?.data ?: listOf(),
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

}