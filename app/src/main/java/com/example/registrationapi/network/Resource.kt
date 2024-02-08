package com.example.registrationapi.network

sealed class Resource {
    data class Success(val token: String) : Resource()
    data class Error(val errorMessage: String) : Resource()
}