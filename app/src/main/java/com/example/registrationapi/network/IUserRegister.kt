package com.example.registrationapi.network

import com.example.registrationapi.data.ApiResponse
import com.example.registrationapi.data.UserData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface IUserRegister {
    @POST("register")
    suspend fun registerUser(@Body request: UserData): Response<ApiResponse>
    suspend fun loginUser(@Body request: UserData): Response<ApiResponse>
}