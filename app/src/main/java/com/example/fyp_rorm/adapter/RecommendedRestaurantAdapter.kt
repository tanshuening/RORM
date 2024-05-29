package com.example.fyp_rorm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp_rorm.databinding.RecommendedRestaurantBinding

class RecommendedRestaurantAdapter (private val items: List<String>, private val ratings: List<String>,
                                       private val tag: List<String>, private val image:List<Int>): RecyclerView.Adapter<RecommendedRestaurantAdapter.RecommendedRestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedRestaurantViewHolder {
        return RecommendedRestaurantViewHolder(RecommendedRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecommendedRestaurantViewHolder, position: Int) {
        val item = items[position]
        val rating = ratings[position]
        val tag = tag[position]
        val images = image[position]
        holder.bind(item, rating, tag, images)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RecommendedRestaurantViewHolder (private val binding: RecommendedRestaurantBinding): RecyclerView.ViewHolder(binding.root) {

        private val imagesView = binding.restaurantImageRecommended
        fun bind(item: String, rating: String, tag: String, images: Int) {
            binding.restaurantNameRecommended.text = item
            binding.restaurantRatingsRecommended.text = rating
            binding.restaurantTagRecommended.text = tag
            imagesView.setImageResource(images)
        }
    }

}