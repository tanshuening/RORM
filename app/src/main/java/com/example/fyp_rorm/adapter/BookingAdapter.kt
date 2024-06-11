package com.example.fyp_rorm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp_rorm.databinding.CardViewBookingTimeBinding
import com.example.fyp_rorm.databinding.CardViewRestaurantMenuBinding

class BookingAdapter(
    private var timeSlots: ArrayList<String>
) : RecyclerView.Adapter<BookingAdapter.BookingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        val binding = CardViewBookingTimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        val timeSlot = timeSlots[position]
        holder.bind(timeSlot)
    }

    override fun getItemCount(): Int {
        return timeSlots.size
    }

    fun updateTimeSlots(newTimeSlots: ArrayList<String>) {
        timeSlots = newTimeSlots
        notifyDataSetChanged()
    }

    class BookingViewHolder(private val binding: CardViewBookingTimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(timeSlot: String) {
            binding.timeSlot.text = timeSlot
        }
    }
}
