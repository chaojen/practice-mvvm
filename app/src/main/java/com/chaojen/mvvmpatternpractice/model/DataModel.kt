package com.chaojen.mvvmpatternpractice.model

import androidx.lifecycle.MutableLiveData
import com.chaojen.mvvmpatternpractice.api.RetrofitManager
import com.chaojen.mvvmpatternpractice.model.data.Repo
import com.chaojen.mvvmpatternpractice.model.data.RepoSearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataModel {

    private val githubService = RetrofitManager.githubService

    fun searchRepo(query: String): MutableLiveData<MutableList<Repo>> {
        val repos = MutableLiveData<MutableList<Repo>>()
        githubService.searchRepos(query)
            .enqueue(object : Callback<RepoSearchResponse> {
                override fun onResponse(call: Call<RepoSearchResponse>, response: Response<RepoSearchResponse>) {
                    repos.value = response.body()?.items ?: mutableListOf()
                }

                override fun onFailure(call: Call<RepoSearchResponse>, t: Throwable) {
                }
            })
        return repos
    }
}