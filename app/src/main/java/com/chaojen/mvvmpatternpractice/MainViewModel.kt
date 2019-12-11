package com.chaojen.mvvmpatternpractice

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField

class MainViewModel {

    private val dataModel = DataModel()
    var mData = ObservableField<String>()
    var isLoading = ObservableBoolean()

    fun refresh() {
        isLoading.set(true)
        dataModel.retrieveData(object : DataModel.OnDataReadyCallback {
            override fun onDataReady(data: String) {
                mData.set(data)
                isLoading.set(false)
            }
        })
    }
}