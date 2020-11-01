package com.example.fetchgithubtokotlinretrofit.api

import com.example.fetchgithubtokotlinretrofit.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("users")
    suspend fun getAllUsers(): Response<List<Users>>
}