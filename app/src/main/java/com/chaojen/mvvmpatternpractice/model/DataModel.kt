package com.chaojen.mvvmpatternpractice.model

import androidx.lifecycle.LiveData
import com.chaojen.mvvmpatternpractice.api.ApiResponse
import com.chaojen.mvvmpatternpractice.api.RetrofitManager
import com.chaojen.mvvmpatternpractice.model.data.RepoSearchResponse

class DataModel {

    private val githubService = RetrofitManager.githubService

    fun searchRepo(query: String): LiveData<ApiResponse<RepoSearchResponse>> {
        return githubService.searchRepos(query)
    }
}