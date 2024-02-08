package com.example.registrationapi.network

import com.example.registrationapi.data.UserData
import retrofit2.http.Field
import retrofit2.http.POST

interface IUserLogin {
    @POST("login")
    suspend fun registerUser(
        @Field("email") email:String,
        @Field("password") password:String
    ): UserData
}