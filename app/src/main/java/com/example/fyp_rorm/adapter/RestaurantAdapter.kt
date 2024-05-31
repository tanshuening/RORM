package com.example.fyp_rorm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp_rorm.databinding.RestaurantBinding

class RestaurantAdapter (private val items: List<String>, private val ratings: List<String>,
                                       private val tag: List<String>, private val image:List<Int>): RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(RestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = items[position]
        val rating = ratings[position]
        val tag = tag[position]
        val images = image[position]
        holder.bind(item, rating, tag, images)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RestaurantViewHolder (private val binding: RestaurantBinding): RecyclerView.ViewHolder(binding.root) {

        private val imagesView = binding.restaurantImage
        fun bind(item: String, rating: String, tag: String, images: Int) {
            binding.restaurantName.text = item
            binding.restaurantRatings.text = rating
            binding.restaurantTag.text = tag
            imagesView.setImageResource(images)
        }
    }

}