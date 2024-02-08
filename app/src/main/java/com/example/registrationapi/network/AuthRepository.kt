package com.example.registrationapi.network

import com.example.registrationapi.data.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class AuthRepository() {
    private val apiService = Retrofit.apiService

    suspend fun loginUser(email:String,password:String): Flow<Resource> = flow{
        try {
            val response = apiService.loginUser(UserData(email, password))
            response.let {
                if (response.isSuccessful){
                    val token = response.body()?.token
                    if (token != null){
                        emit(Resource.Success(token))
                    }else{
                        emit(Resource.Error("Login failed: Token is null"))
                    }
                }else{
                    val errorBody = response.errorBody()?.string()
                    if (response.code() == 400 && !errorBody.isNullOrBlank()){
                        val errorMessage = try {
                            val json = JSONObject(errorBody)
                            json.optString("error","Unknown error")
                        }catch (e: JSONException){
                            "Unknown error"
                        }
                        emit(Resource.Error("Login failed: $errorMessage"))
                    }else{
                        emit(Resource.Error("Login Failed: ${response.code()}"))
                    }
                }
            }

        }catch (e:Exception){
            emit(Resource.Error("Login failed:${e.message}"))
        }
    }

    suspend fun registerUser(email: String,password: String):Flow<Resource> = flow {
        try {
            val response = apiService.registerUser(UserData(email, password))
            if (response.isSuccessful){
                val token = response.body()?.token
                if (token != null){
                    emit(Resource.Success(token))
                }else{
                    emit(Resource.Error("Registration failed: Token is null"))
                }
            }else{
                emit(Resource.Error("Registration failed: ${response.code()}"))
            }
        }catch (e:Exception){
            emit(Resource.Error("Registration failed:${e.message}"))
        }
    }
}
