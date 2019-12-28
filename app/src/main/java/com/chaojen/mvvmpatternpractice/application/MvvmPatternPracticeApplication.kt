package com.chaojen.mvvmpatternpractice.application

import android.app.Application
import com.chaojen.mvvmpatternpractice.api.RetrofitManager

class MvvmPatternPracticeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitManager.init()
    }
}