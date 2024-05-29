package com.example.fyp_rorm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp_rorm.databinding.BrowseByCuisineBinding

class BrowseByCuisineAdapter(
    private val cuisines: List<String>,
    private val images: List<Int>
) : RecyclerView.Adapter<BrowseByCuisineAdapter.BrowseByCuisineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrowseByCuisineViewHolder {
        val binding = BrowseByCuisineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BrowseByCuisineViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrowseByCuisineViewHolder, position: Int) {
        val cuisine = cuisines[position]
        val image = images[position]
        holder.bind(cuisine, image)
    }

    override fun getItemCount(): Int {
        return cuisines.size
    }

    class BrowseByCuisineViewHolder(private val binding: BrowseByCuisineBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cuisine: String, image: Int) {
            binding.cuisineName.text = cuisine
            binding.restaurantImage.setImageResource(image)
        }
    }
}
