package com.example.challenge_chapter5.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.challenge_chapter5.R
import com.example.challenge_chapter5.databinding.FragmentProfileBinding
import java.util.*

class ProfileFragment : Fragment() {
    lateinit var binding : FragmentProfileBinding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefs = requireActivity().getSharedPreferences("dataUser",Context.MODE_PRIVATE)
        val getUsername = sharedPrefs.getString("username","")
        val getEmail = sharedPrefs.getString("email","")

        binding.etUsername.setText(getUsername)
        binding.etEmail.setText(getEmail)

        binding.btnLogout.setOnClickListener{
            clearData()
            Navigation.findNavController(it).navigate(R.id.action_profileFragment_to_loginFragment)
            Toast.makeText(context,"Anda berhasil keluar!", Toast.LENGTH_SHORT).show()

        }

        binding.btnUpdate.setOnClickListener {
            var username = binding.etUsername.text.toString()
            var email = binding.etEmail.text.toString()
            var password = binding.etPassword.text.toString()
            var passwordComfirm = binding.etPasswordConfirm.text.toString()
            var edit =sharedPrefs.edit()

            if (password.equals(passwordComfirm)){
                edit.putString("username",username)
                edit.putString("email",email)
                edit.putString("password",password)
                edit.putString("passwordconfirm",passwordComfirm)
                edit.commit()
                Navigation.findNavController(it).navigate(R.id.action_profileFragment_to_homeFragment)
                Toast.makeText(context,"Data berhasil diubah",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnUs.setOnClickListener{
            setLocale("en")
        }
        binding.btnIdn.setOnClickListener{
            setLocale("in")
        }
    }

    fun clearData(){
        var pref = sharedPrefs.edit()
        pref.clear()
        pref.apply()
    }

    fun setLocale(lang : String?){
        val jamal = requireActivity()
        val mylocale = Locale(lang)
        val res = resources
        val conf = res.configuration
        conf.locale = mylocale
        res.updateConfiguration(conf,res.displayMetrics)
        startActivity(Intent(context, MainActivity::class.java))
        jamal.finish()
    }


}