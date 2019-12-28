package com.chaojen.mvvmpatternpractice.model.data

import androidx.annotation.NonNull
import com.google.gson.annotations.SerializedName

data class Repo(
    val id: Int,
    @SerializedName("name") @NonNull val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val description: String,
    @SerializedName("stargazers_count") val starts: Int,
    @SerializedName("owner") val owner: Owner
)