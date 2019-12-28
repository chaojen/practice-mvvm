package com.chaojen.mvvmpatternpractice.model

import com.chaojen.mvvmpatternpractice.api.RetrofitManager
import com.chaojen.mvvmpatternpractice.model.data.Repo
import com.chaojen.mvvmpatternpractice.model.data.RepoSearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataModel {

    private val githubService = RetrofitManager.githubService

    fun searchRepo(query: String, onDataReadyCallback: OnDataReadyCallback) {
        githubService.searchRepos(query)
            .enqueue(object : Callback<RepoSearchResponse> {
                override fun onResponse(call: Call<RepoSearchResponse>, response: Response<RepoSearchResponse>) {
                    onDataReadyCallback.onDataReady(response.body()?.items ?: mutableListOf())
                }

                override fun onFailure(call: Call<RepoSearchResponse>, t: Throwable) {
                }
            })
    }

    interface OnDataReadyCallback {
        fun onDataReady(data: MutableList<Repo>)
    }
}