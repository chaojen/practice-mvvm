package com.chaojen.mvvmpatternpractice.viewmodel

import android.text.TextUtils
import androidx.arch.core.util.Function
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.chaojen.mvvmpatternpractice.model.DataModel
import com.chaojen.mvvmpatternpractice.model.data.Repo
import com.chaojen.mvvmpatternpractice.util.AbsentLiveData

class RepoViewModel(private val dataModel: DataModel) : ViewModel() {

    val isLoading = ObservableBoolean()
    val repos: LiveData<MutableList<Repo>>
    private val query = MutableLiveData<String>()

    init {
        repos = Transformations.switchMap(query, object : Function<String, LiveData<MutableList<Repo>>> {
            override fun apply(input: String?): LiveData<MutableList<Repo>> {
                return if (TextUtils.isEmpty(input)) {
                    AbsentLiveData.create()
                } else {
                    dataModel.searchRepo(input ?: "")
                }
            }
        })
    }

    fun searchRepo(userInput: String) {
        query.value = userInput
    }
}