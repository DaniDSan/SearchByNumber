package com.example.searchbynumbers.data.network.modelList

import com.squareup.moshi.Json

data class UserResponse(
    @Json(name = "total_count") val total: Int,
    @Json(name = "incomplete_results") val incomplete: Boolean,
    val items: List<User>
)
