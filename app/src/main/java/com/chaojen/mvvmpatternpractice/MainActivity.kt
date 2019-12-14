package com.chaojen.mvvmpatternpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.chaojen.mvvmpatternpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val factory = GithubViewModelFactory(DataModel())
        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        viewModel.mData.observe(this, Observer<String> {
            binding.txtHelloWord.text = it
        })

        viewModel.toastText.observe(this, Observer {
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
        })

        binding.viewModel = viewModel
    }
}
