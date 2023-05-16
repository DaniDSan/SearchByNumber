package com.example.searchbynumbers.data.network.modelList

import com.squareup.moshi.Json

data class User(
    val login: String,
    @Json(name = "repos_url") val reposUrl: String,
    @Json(name = "followers_url") val followersUrl: String,
    @Json(name = "avatar_url") val avatarUrl: String,
    )
