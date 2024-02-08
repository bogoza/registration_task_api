package com.example.registrationapi.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrationapi.data.UserData
import com.example.registrationapi.network.AuthRepository
import com.example.registrationapi.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    private val _userList = MutableStateFlow<Resource?>(null)
    val userList:StateFlow<Resource?> get() = _userList

    private val repository: AuthRepository = AuthRepository()

    fun loginUser(email:String,password:String){
        viewModelScope.launch{
            repository.loginUser(email, password).collect{
                _userList.value = it
            }
        }
    }
}