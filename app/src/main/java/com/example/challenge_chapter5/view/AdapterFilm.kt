package com.example.challenge_chapter5.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challenge_chapter5.R
import com.example.challenge_chapter5.databinding.ItemMovieBinding
import com.example.challenge_chapter5.model.ResponseDataFilmItem

class AdapterFilm (var dataFilm : List<ResponseDataFilmItem>) : RecyclerView.Adapter<AdapterFilm.ViewHolder>(){
    class ViewHolder(val binding : ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(dataFilm[position].image).into(holder.binding.image)
        holder.binding.name.text = dataFilm[position].name
        holder.binding.description.text = dataFilm[position].director

        holder.binding.btnDetail.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("judul", dataFilm[position].name)
            bundle.putString("date", dataFilm[position].date)
            bundle.putString("gambar", dataFilm[position].image)
            bundle.putString("director",dataFilm[position].director)
            bundle.putString("deskripsi", dataFilm[position].description)
            bundle.putInt("id", dataFilm[position].id.toInt())
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_detailFragment,bundle)
        }
    }

    override fun getItemCount(): Int {
        return dataFilm.size
    }
    fun setData(data: ArrayList<ResponseDataFilmItem>) {
        this.dataFilm = data
    }
}