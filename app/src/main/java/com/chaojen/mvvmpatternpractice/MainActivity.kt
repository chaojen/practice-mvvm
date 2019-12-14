package com.chaojen.mvvmpatternpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.chaojen.mvvmpatternpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val factory = GithubViewModelFactory(DataModel())
        binding.viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
    }
}
