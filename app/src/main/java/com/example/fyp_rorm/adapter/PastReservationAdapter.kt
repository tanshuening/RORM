package com.example.fyp_rorm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp_rorm.databinding.CardViewPastReservationBinding

class PastReservationAdapter(private val pastReservationRestaurantName: ArrayList<String>,
                             private val pastReservationRestaurantRatings: ArrayList<String>,
                             private val pastReservationRestaurantTag: ArrayList<String>,
                             private val pastReservationRestaurantImage: ArrayList<Int>):
    RecyclerView.Adapter<PastReservationAdapter.PastReservationViewHolder>() {
        
    override fun onBindViewHolder(holder: PastReservationViewHolder, position: Int) {
        holder.bind(pastReservationRestaurantName[position], pastReservationRestaurantRatings[position], pastReservationRestaurantTag[position], pastReservationRestaurantImage[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastReservationViewHolder {
        val binding = CardViewPastReservationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PastReservationViewHolder(binding)
    }

    override fun getItemCount(): Int = pastReservationRestaurantName.size
    class PastReservationViewHolder(private val binding:CardViewPastReservationBinding): RecyclerView.ViewHolder
        (binding.root){
            fun bind(pastReservationRestaurantName: String, pastReservationRestaurantRatings: String, pastReservationRestaurantTag: String, pastReservationRestaurantImage: Int){
                binding.restaurantName.text = pastReservationRestaurantName
                binding.restaurantRatings.text = pastReservationRestaurantRatings
                binding.restaurantTag.text = pastReservationRestaurantTag
                binding.restaurantImage.setImageResource(pastReservationRestaurantImage)
            }
    }
}