package com.example.kotlin_retrofit_mvvm.network

import com.example.kotlin_retrofit_mvvm.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("todos/{userId}")
    suspend fun getUser(
        @Path("userId") userId: String
    ):User


}