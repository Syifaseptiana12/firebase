package com.example.challenge_chapter5.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.challenge_chapter5.R
import com.example.challenge_chapter5.databinding.FragmentDetailBinding
import com.example.challenge_chapter5.databinding.FragmentSplashBinding

class DetailFragment : Fragment() {
    lateinit var binding : FragmentDetailBinding
    lateinit var sharedPrefs : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var judul = arguments?.getString("judul")
        var date = arguments?.getString("date")
        var deskripsi = arguments?.getString("deskripsi")
        var director = arguments?.getString("director")
        var gambar = arguments?.getString("gambar")
        var id = arguments?.getInt("id")

        binding.nameMovie.text =judul
        binding.txtDate.text = date
        binding.txtDescription.text = deskripsi
        binding.txtDirector.text = director
        Glide.with(this).load(gambar).into(binding.imgMovie)
    }

}