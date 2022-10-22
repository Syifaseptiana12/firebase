package com.fal.crudfilmapps.network

import com.example.challenge_chapter5.model.DataFilm
import com.example.challenge_chapter5.model.ResponseDataFilmItem
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET("film")
    fun getAll() : Call<List<ResponseDataFilmItem>>

    @POST("film")
    fun addData(@Body film : DataFilm) : Call<ResponseDataFilmItem>


    @DELETE("film/{id}")
    fun deleteFilm(@Path("id") id : Int) : Call<Int>
}