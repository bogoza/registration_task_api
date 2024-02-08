package com.example.registrationapi.data

data class UserData (
    val email:String,
    val password:String
)
data class ApiResponse(val token: String)