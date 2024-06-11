package com.example.fyp_rorm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp_rorm.databinding.CardViewRecommendedRestaurantBinding

class RecommendedRestaurantAdapter (private val items: List<String>, private val ratings: List<String>,
                                       private val tag: List<String>, private val image:List<Int>): RecyclerView.Adapter<RecommendedRestaurantAdapter.RecommendedRestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedRestaurantViewHolder {
        return RecommendedRestaurantViewHolder(CardViewRecommendedRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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

    class RecommendedRestaurantViewHolder (private val binding: CardViewRecommendedRestaurantBinding): RecyclerView.ViewHolder(binding.root) {

        private val imagesView = binding.restaurantImage
        fun bind(item: String, rating: String, tag: String, images: Int) {
            binding.restaurantName.text = item
            binding.restaurantRatings.text = rating
            binding.restaurantTag.text = tag
            imagesView.setImageResource(images)
        }
    }

}