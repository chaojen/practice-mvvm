package com.chaojen.mvvmpatternpractice.model.data

import androidx.annotation.NonNull
import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("login") @NonNull val login: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") val url: String,
    @SerializedName("contributions") val contributions: Int
)