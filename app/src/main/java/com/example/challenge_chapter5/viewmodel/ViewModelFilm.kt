package com.example.challenge_chapter5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_chapter5.model.ResponseDataFilmItem
import com.fal.crudfilmapps.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelFilm : ViewModel() {

    lateinit var getData : MutableLiveData<List<ResponseDataFilmItem>?>

    init {
        getData = MutableLiveData()

    }

    fun allLiveData() : MutableLiveData<List<ResponseDataFilmItem>?> {
        return getData
    }

    fun showList() {
        RetrofitClient.instance.getAll()
            .enqueue(object : Callback<List<ResponseDataFilmItem>> {
                override fun onResponse(
                    call: Call<List<ResponseDataFilmItem>>,
                    response: Response<List<ResponseDataFilmItem>>,
                ) {
                    if (response.isSuccessful){
                        getData.postValue(response.body())
                    }else{
                        getData.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataFilmItem>>, t: Throwable) {
                    getData.postValue(null)
                }

            })
    }
    
}