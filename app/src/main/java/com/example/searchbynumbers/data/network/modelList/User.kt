package com.example.searchbynumbers.data.network.modelList

import com.squareup.moshi.Json

data class User(
    val login: String,
    @Json(name = "repos_url") val reposUrl: String,
    )
