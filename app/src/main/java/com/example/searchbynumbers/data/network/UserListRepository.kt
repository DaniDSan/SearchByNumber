package com.example.searchbynumbers.data.network

import com.example.searchbynumbers.data.network.modelList.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.github.com/search/"

class UserListRepository {
    private val retrofit: Retrofit by lazy {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private val userAPI: UserAPI by lazy { retrofit.create(UserAPI::class.java) }

    suspend fun getUser(): ArrayList<User> {
        val response = userAPI.getUsers()
        return if (response.isSuccessful) {
            ArrayList(response.body()?.items ?: arrayListOf())
        } else {
            arrayListOf()
        }
    }
}