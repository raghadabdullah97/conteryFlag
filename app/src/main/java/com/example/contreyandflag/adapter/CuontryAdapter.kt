package com.example.contreyandflag.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contreyandflag.databinding.ItemListBinding
import com.example.contreyandflag.network.FlagPhoto

//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.example.countryapp.databinding.CountryItemBinding
//import com.example.countryapp.model.Country


class CuontryAdapter: androidx.recyclerview.widget.ListAdapter<FlagPhoto, CuontryAdapter.CountryViewHolder>(DiffCallback) {

    class CountryViewHolder(private val binding:ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(countryPhoto: FlagPhoto) {
            binding.countryModel = countryPhoto
            binding.executePendingBindings()
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val flagPhoto = getItem(position)
        println(flagPhoto.flag)
        holder.bind(flagPhoto)
    }


    companion object DiffCallback: DiffUtil.ItemCallback<FlagPhoto>(){
        override fun areItemsTheSame(oldItem: FlagPhoto, newItem: FlagPhoto): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: FlagPhoto, newItem: FlagPhoto): Boolean {
            return oldItem.flag == newItem.flag
        }

    }
}