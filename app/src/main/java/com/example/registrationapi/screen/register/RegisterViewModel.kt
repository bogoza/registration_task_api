package com.example.registrationapi.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrationapi.data.UserData
import com.example.registrationapi.network.AuthRepository
import com.example.registrationapi.network.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RegisterViewModel:ViewModel() {
    private val _userList = MutableStateFlow<Resource?>(null)
    val userList:StateFlow<Resource?> get() = _userList

    private val repository:AuthRepository = AuthRepository()

    fun registerUser(email:String,password:String){
        viewModelScope.launch{
            repository.registerUser(email, password).collect{
                _userList.value = it
            }
        }
    }
}