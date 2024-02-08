package com.example.registrationapi.network

import com.example.registrationapi.data.ApiResponse
import com.example.registrationapi.data.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IUserRegister {
    @POST("register")
    suspend fun registerUser(@Body request: UserData): Response<ApiResponse>
    @POST("login")
    suspend fun loginUser(@Body request: UserData): Response<ApiResponse>
}