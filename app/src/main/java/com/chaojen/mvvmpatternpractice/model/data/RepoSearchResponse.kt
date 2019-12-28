package com.chaojen.mvvmpatternpractice.model.data

import com.google.gson.annotations.SerializedName

data class RepoSearchResponse(
    @SerializedName("total_count") val total: Int,
    @SerializedName("items") val items: MutableList<Repo>
)