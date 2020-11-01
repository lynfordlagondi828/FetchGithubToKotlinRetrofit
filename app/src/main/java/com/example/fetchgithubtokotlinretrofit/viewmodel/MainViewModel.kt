package com.example.fetchgithubtokotlinretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchgithubtokotlinretrofit.model.Users
import com.example.fetchgithubtokotlinretrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myAllUsers:MutableLiveData<Response<List<Users>>> = MutableLiveData()

    fun getAllUsers(){
        viewModelScope.launch {
            val response = repository.getAllUsers()
            myAllUsers.value = response
        }
    }
}