package com.chaojen.mvvmpatternpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chaojen.mvvmpatternpractice.ui.RepoFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tag = RepoFragment.TAG
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, RepoFragment(), tag)
                .commit()
        }
    }
}
