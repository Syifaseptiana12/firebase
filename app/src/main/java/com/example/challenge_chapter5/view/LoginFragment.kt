package com.example.challenge_chapter5.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.challenge_chapter5.R
import com.example.challenge_chapter5.databinding.FragmentLoginBinding
import java.util.*

class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefs = requireActivity().getSharedPreferences("dataUser",Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener{
            var inputEmail = binding.etEmail.text.toString()
            var inputPassword = binding.etPassword.text.toString()
            var getUsername = sharedPrefs.getString("username","")
            var emailSharedPref = sharedPrefs.getString("email","")
            var passwordSharedPref = sharedPrefs.getString("password","")

            if (inputEmail.equals(emailSharedPref) && inputPassword.equals(passwordSharedPref)){
                var bun = Bundle()
                bun.putString("username",getUsername)
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
            }else{
                Toast.makeText(context,"Data Salah!",Toast.LENGTH_SHORT).show()
            }
        }

        binding.txtRegister.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registerFragment)
        }


    }



}