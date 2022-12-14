package com.example.challenge_chapter5.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_chapter5.R
import com.example.challenge_chapter5.databinding.FragmentHomeBinding
import com.example.challenge_chapter5.model.ResponseDataFilmItem
import com.example.challenge_chapter5.viewmodel.ViewModelFilm
import com.fal.crudfilmapps.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var adapterFilm : AdapterFilm
    lateinit var sharedPrefs : SharedPreferences

    lateinit var viewmodelFilm : ViewModelFilm
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefs = requireActivity().getSharedPreferences("dataUser",Context.MODE_PRIVATE)
        val getUsername = sharedPrefs.getString("username","")
        binding.txtUser.text = getUsername


        // Show Data on RV
        setVmtoAdapter()
        //VM
        viewmodelFilm = ViewModelProvider(this).get(ViewModelFilm::class.java)
        viewmodelFilm.allLiveData().observe(viewLifecycleOwner, Observer {
            adapterFilm.setData(it as ArrayList<ResponseDataFilmItem>)
        })

        binding.btnProfile.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_profileFragment)
        }


    }
    fun setVmtoAdapter(){
            val viewModel = ViewModelProvider(this).get(ViewModelFilm::class.java)
        viewModel.showList()
        viewModel.allLiveData().observe(viewLifecycleOwner, Observer {
            //RV
            adapterFilm = AdapterFilm(ArrayList())
            binding.rvMovie.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.rvMovie.adapter = adapterFilm
        })
    }



}