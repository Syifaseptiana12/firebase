package com.example.challenge_chapter5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_chapter5.model.ResponseDataFilmItem

class ViewModelFilm : ViewModel() {

    lateinit var getData : MutableLiveData<List<ResponseDataFilmItem>>

    init {
        getData = MutableLiveData()

    }

    fun allLiveData() : MutableLiveData<List<ResponseDataFilmItem>>{
        return getData
    }
    
}