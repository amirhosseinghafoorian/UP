package com.a.up

import androidx.paging.PagingSource
import com.a.up.home.data.HomeRemote
import kotlinx.coroutines.flow.collect

class PagingTest(
    private val backend: HomeRemote,

    ) : PagingSource<Int, String>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = backend.fillAllUsersFromRemote(nextPageNumber)
            val list = mutableListOf<String>()
            response.collect {
                list.add(it)
            }
            LoadResult.Page(
                data = list,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
            // Handle errors in this block and return LoadResult.Error if it is an
            // expected error (such as a network failure).
        }


    }

}