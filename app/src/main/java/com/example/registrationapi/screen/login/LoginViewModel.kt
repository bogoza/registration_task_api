package com.example.registrationapi.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrationapi.data.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    private val _userList = MutableStateFlow<List<UserData>>(emptyList())
    val userList:StateFlow<List<UserData>> = _userList

    fun loginUser(email:String,password:String){
        viewModelScope.launch{
            
        }
    }
}