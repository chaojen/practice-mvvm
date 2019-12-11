package com.chaojen.mvvmpatternpractice

import android.os.Handler

class DataModel {

    fun retrieveData(callback: OnDataReadyCallback) {
        Handler().postDelayed({
            callback.onDataReady("new data")
        }, 1500)
    }

    interface OnDataReadyCallback {
        fun onDataReady(data: String)
    }
}