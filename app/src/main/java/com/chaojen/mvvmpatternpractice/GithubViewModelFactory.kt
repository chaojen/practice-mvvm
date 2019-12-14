package com.chaojen.mvvmpatternpractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class GithubViewModelFactory(private val dataModel: DataModel) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dataModel) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}