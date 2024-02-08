package com.example.registrationapi.network

import com.example.registrationapi.data.UserData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.POST

object Retrofit {
    val retrofit by lazy {

        Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(moshi)
            .build()

    }
    private val moshi:MoshiConverterFactory = MoshiConverterFactory.create(Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build())

}