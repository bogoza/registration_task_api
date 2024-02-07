package com.example.registrationapi.home

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.registrationapi.R
import com.example.registrationapi.base.BaseFragment
import com.example.registrationapi.databinding.FragmentHomeBinding


class HomeFrag : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun start() {
        listener()
    }

    private fun listener()= with(binding){
        loginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFrag2_to_loginFrag)
        }
        registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFrag2_to_registerFrag2)
        }
    }
}