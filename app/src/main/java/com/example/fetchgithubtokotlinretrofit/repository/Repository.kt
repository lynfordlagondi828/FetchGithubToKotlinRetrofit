package com.example.fetchgithubtokotlinretrofit.repository

import com.example.fetchgithubtokotlinretrofit.api.RetrofitInstance
import com.example.fetchgithubtokotlinretrofit.model.Users
import retrofit2.Response

class Repository {

    suspend fun getAllUsers():Response<List<Users>>{
        return RetrofitInstance.api.getAllUsers()
    }
}