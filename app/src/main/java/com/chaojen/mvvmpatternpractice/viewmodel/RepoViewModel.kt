package com.chaojen.mvvmpatternpractice.viewmodel

import android.text.TextUtils
import androidx.arch.core.util.Function
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.chaojen.mvvmpatternpractice.api.ApiResponse
import com.chaojen.mvvmpatternpractice.model.DataModel
import com.chaojen.mvvmpatternpractice.model.data.RepoSearchResponse
import com.chaojen.mvvmpatternpractice.util.AbsentLiveData

class RepoViewModel(private val dataModel: DataModel) : ViewModel() {

    val isLoading = ObservableBoolean()
    val repos: LiveData<ApiResponse<RepoSearchResponse>>
    private val query = MutableLiveData<String>()

    init {
        repos = Transformations.switchMap(query, object : Function<String, LiveData<ApiResponse<RepoSearchResponse>>> {
            override fun apply(input: String?): LiveData<ApiResponse<RepoSearchResponse>>? {
                return if (TextUtils.isEmpty(input)) AbsentLiveData.create() else dataModel.searchRepo(input ?: "")
            }
        })
    }

    fun searchRepo(userInput: String) {
        query.value = userInput
    }
}