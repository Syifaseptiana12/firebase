package com.example.challenge_chapter5.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.challenge_chapter5.R
import com.example.challenge_chapter5.databinding.FragmentSplashBinding


@Suppress("DEPRECATION")
class SplashFragment : Fragment() {
    private lateinit var binding : FragmentSplashBinding
    private lateinit var sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentSplashBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val splashTime : Long = 3000

        sharedPrefs = requireActivity().getSharedPreferences("dataUser",Context.MODE_PRIVATE)
        val getData = sharedPrefs.getString("username","")

        if (getData != ""){
            val getFullName = sharedPrefs.getString("fullName","")
            val bun = Bundle()
            bun.putString("fullName",getFullName)
            Handler().postDelayed({
                Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_homeFragment,bun)

            },splashTime)
        }else{
            Handler().postDelayed({
                Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_loginFragment)

            },splashTime)
        }

    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }
}