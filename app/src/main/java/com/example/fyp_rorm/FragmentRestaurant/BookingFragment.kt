package com.example.fyp_rorm.FragmentRestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp_rorm.adapter.BookingAdapter
import com.example.fyp_rorm.databinding.FragmentBookingBinding

class BookingFragment : Fragment() {
    private lateinit var binding: FragmentBookingBinding
    private lateinit var bookingAdapter: BookingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookingBinding.inflate(inflater, container, false)
        setupSpinner()
        setupRecyclerView()
        setupNumOfPaxClickListener()
        setupViewButtonClickListener()
        return binding.root
    }

    private fun setupSpinner() {
        val paxOptions = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, paxOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.numOfPaxSpinner.adapter = adapter
    }

    private fun setupRecyclerView() {
        val timeSlot = arrayListOf(
            "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"
        )

        bookingAdapter = BookingAdapter(timeSlot)

        binding.bookingTimeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.bookingTimeRecyclerView.adapter = bookingAdapter
    }

    private fun setupNumOfPaxClickListener() {
        binding.numOfPax.setOnClickListener {
            binding.numOfPaxSpinner.performClick()
        }
    }

    private fun setupViewButtonClickListener() {
        binding.viewButton.setOnClickListener {
            val allTimeSlots = arrayListOf(
                "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"
            )
            bookingAdapter.updateTimeSlots(allTimeSlots)
        }
    }
}
