package com.example.fyp_rorm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp_rorm.databinding.RecentlyViewedRestaurantBinding

class RecentlyViewedRestaurantAdapter (private val items: List<String>, private val ratings: List<String>,
                                       private val tag: List<String>, private val image:List<Int>): RecyclerView.Adapter<RecentlyViewedRestaurantAdapter.RecentlyViewedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentlyViewedViewHolder {
        return RecentlyViewedViewHolder(RecentlyViewedRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecentlyViewedViewHolder, position: Int) {
        val item = items[position]
        val rating = ratings[position]
        val tag = tag[position]
        val images = image[position]
        holder.bind(item, rating, tag, images)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RecentlyViewedViewHolder (private val binding: RecentlyViewedRestaurantBinding): RecyclerView.ViewHolder(binding.root) {

        private val imagesView = binding.restaurantImage
        fun bind(item: String, rating: String, tag: String, images: Int) {
            binding.restaurantName.text = item
            binding.restaurantRatings.text = rating
            binding.restaurantTag.text = tag
            imagesView.setImageResource(images)
        }
    }

}