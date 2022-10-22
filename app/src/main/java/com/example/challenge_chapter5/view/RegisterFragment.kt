package com.example.challenge_chapter5.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.challenge_chapter5.R
import com.example.challenge_chapter5.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    lateinit var binding : FragmentRegisterBinding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefs = requireActivity().getSharedPreferences("dataUser",Context.MODE_PRIVATE)

        binding.btnDaftar.setOnClickListener{
            var username = binding.etUsername.text.toString()
            var email = binding.etEmail.text.toString()
            var namaLengkap = binding.etNamaLengkap.text.toString()
            var alamat = binding.etAlamat.text.toString()
            var tanggalLahir = binding.etTanggalLahir.text.toString()
            var password = binding.etPassword.text.toString()
            var passwordConfirm = binding.etPasswordConfirm.text.toString()

            var addUser = sharedPrefs.edit()

            if (passwordConfirm.equals(password)){
                addUser.putString("username",username)
                addUser.putString("email",email)
                addUser.putString("namalengkap",namaLengkap)
                addUser.putString("alamat",alamat)
                addUser.putString("tanggallahir",tanggalLahir)
                addUser.putString("password",password)
                addUser.putString("passwordconfirm",passwordConfirm)
                addUser.apply()
                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
                Toast.makeText(context,"Daftar akun berhasil!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"Periksa kembali data Anda!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}