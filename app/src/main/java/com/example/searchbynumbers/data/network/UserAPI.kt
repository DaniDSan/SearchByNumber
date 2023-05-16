package com.example.searchbynumbers.data.network

import com.example.searchbynumbers.data.network.modelList.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserAPI {
    @GET("users")
    suspend fun getUsers(
        @Query("q") query: String = "followers:>=1000",
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20
    ): Response<UserResponse>
}