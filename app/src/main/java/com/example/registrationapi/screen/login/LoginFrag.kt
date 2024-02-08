package com.example.registrationapi.screen.login

import android.util.Log.e
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.registrationapi.screen.base.BaseFragment
import com.example.registrationapi.databinding.FragmentLoginBinding
import com.example.registrationapi.network.Resource
import kotlinx.coroutines.launch


class LoginFrag : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel:LoginViewModel by viewModels()
    override fun start() {
        listener()
    }

    private fun listener() = with(binding) {
        loginBtn.setOnClickListener {
            viewModel.loginUser(emailEt.text.toString(),passEt.text.toString())
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
                            e("errorLoginError", "$errorMessage")
                            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
                        }
                    }
                }

            }
        }
    }
}