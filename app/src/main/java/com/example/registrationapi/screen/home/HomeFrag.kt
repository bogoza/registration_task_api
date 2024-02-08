package com.example.registrationapi.screen.home

import androidx.navigation.fragment.findNavController
import com.example.registrationapi.databinding.FragmentHomeBinding
import com.example.registrationapi.screen.base.BaseFragment


class HomeFrag : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun start() {
        listener()
    }

    private fun listener() = with(binding){
        loginBtn.setOnClickListener {
            findNavController().navigate(HomeFragDirections.actionHomeFrag2ToLoginFrag())
        }
        registerBtn.setOnClickListener {
            findNavController().navigate(HomeFragDirections.actionHomeFrag2ToRegisterFrag2())
        }
    }
}