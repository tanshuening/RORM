package com.example.fyp_rorm.FragmentRestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp_rorm.R
import com.example.fyp_rorm.adapter.ReviewAdapter
import com.example.fyp_rorm.databinding.FragmentReviewBinding

class ReviewFragment : Fragment() {
    private lateinit var binding: FragmentReviewBinding
    private lateinit var reviewAdapter: ReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReviewBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val customerName = arrayListOf("Customer Name 1", "Customer Name 2", "Customer Name 3")
        val date = arrayListOf("Date 1", "Date 2", "Date 3")
        val review = arrayListOf("Review 1", "Review 2", "Review 3")
        val profilePicture = arrayListOf(R.drawable.profile_circle, R.drawable.profile_circle, R.drawable.profile_circle)
        reviewAdapter = ReviewAdapter(customerName, profilePicture, date, review)

        binding.reviewRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.reviewRecyclerView.adapter = reviewAdapter
    }

    companion object {

    }

}
