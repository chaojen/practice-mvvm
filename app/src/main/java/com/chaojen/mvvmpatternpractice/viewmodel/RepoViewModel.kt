package com.chaojen.mvvmpatternpractice.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chaojen.mvvmpatternpractice.model.DataModel
import com.chaojen.mvvmpatternpractice.model.data.Repo

class RepoViewModel : ViewModel() {

    val isLoading = ObservableBoolean()
    val repos = MutableLiveData<MutableList<Repo>>()
    private val dataModel =  DataModel()

    fun searchRepo(query: String) {
        isLoading.set(true)
        dataModel.searchRepo(query, object : DataModel.OnDataReadyCallback {
            override fun onDataReady(data: MutableList<Repo>) {
                repos.value = data
                isLoading.set(false)
            }
        })
    }
}