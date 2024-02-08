package com.example.registrationapi.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrationapi.data.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel:ViewModel() {
    private val _userList = MutableStateFlow<List<UserData>>(emptyList())
    val userList:StateFlow<List<UserData>> = _userList

    fun registerUser(email:String,password:String){
        viewModelScope.launch{

        }
    }
}