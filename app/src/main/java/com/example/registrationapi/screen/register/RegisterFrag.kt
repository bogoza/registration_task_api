package com.example.registrationapi.screen.register

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.registrationapi.screen.base.BaseFragment
import com.example.registrationapi.databinding.FragmentRegisterBinding
import com.example.registrationapi.network.Resource
import kotlinx.coroutines.launch


class RegisterFrag : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate){
    private val viewModel:RegisterViewModel by viewModels()
    override fun start() {
        listener()
    }

    private fun listener() = with(binding){
        registerBtn.setOnClickListener {
            viewModel.registerUser(usernameEt.text.toString(),passEt.text.toString())
            observe()
        }
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userList.collect { result ->
                result?.let {
                    when (result) {
                        is Resource.Success -> {
                            // Success login
                            val token = result.token
                        }
                        is Resource.Error -> {
                            // Error message
                            val errorMessage = result.errorMessage
                            Log.e("errorLoginError", "$errorMessage")
                            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
                        }
                    }
                }

            }
        }
    }
}