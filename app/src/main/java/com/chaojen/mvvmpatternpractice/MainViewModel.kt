package com.chaojen.mvvmpatternpractice

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val dataModel: DataModel) : ViewModel() {

    val mData = MutableLiveData<String>()
    val isLoading = ObservableBoolean()
    val toastText = SingleLiveEvent<String>()

    fun refresh() {
        isLoading.set(true)
        dataModel.retrieveData(object : DataModel.OnDataReadyCallback {
            override fun onDataReady(data: String) {
                mData.value = data
                toastText.value = "done"
                isLoading.set(false)
            }
        })
    }
}