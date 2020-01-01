package com.chaojen.mvvmpatternpractice.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String) {
        val context = imageView.context
        Glide.with(context)
            .load(url)
            .into(imageView)
    }
}