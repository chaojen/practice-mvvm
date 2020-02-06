package com.chaojen.mvvmpatternpractice.api

import androidx.lifecycle.LiveData
import com.chaojen.mvvmpatternpractice.model.data.RepoSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String): LiveData<ApiResponse<RepoSearchResponse>>
}