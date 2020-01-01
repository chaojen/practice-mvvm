package com.chaojen.mvvmpatternpractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chaojen.mvvmpatternpractice.model.DataModel
import java.lang.IllegalArgumentException

class GithubViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepoViewModel::class.java)) {
            return RepoViewModel(DataModel()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}