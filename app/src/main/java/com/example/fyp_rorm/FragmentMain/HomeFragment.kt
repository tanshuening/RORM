package com.example.fyp_rorm.FragmentMain

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.fyp_rorm.CartActivity
import com.example.fyp_rorm.R
import com.example.fyp_rorm.adapter.BrowseByCuisineAdapter
import com.example.fyp_rorm.adapter.RecentlyViewedRestaurantAdapter
import com.example.fyp_rorm.adapter.RecommendedRestaurantAdapter
import com.example.fyp_rorm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFloatingActionButton()
        setupImageSlider()
        setupRecyclerViews()
    }

    private fun setupFloatingActionButton() {
        binding.fab.setOnClickListener {
            // Start the CartActivity without delay
            val intent = Intent(activity, CartActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupImageSlider() {
        val imageList = ArrayList<SlideModel>().apply {
            add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
            add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
            add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        }

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                // Implement double click action if needed
            }

            override fun onItemSelected(position: Int) {
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerViews() {
        val restaurantName = listOf("iVegan", "Sando", "Colony Bakery")
        val rating = listOf("5.0", "4.5", "4.0")
        val tag = listOf("Vegan", "Bakery", "Bakery")
        val restaurantImage = listOf(R.drawable.restaurant, R.drawable.restaurant2, R.drawable.restaurant3)
        val recentlyViewedAdapter = RecentlyViewedRestaurantAdapter(restaurantName, rating, tag, restaurantImage)

        binding.recentlyViewedRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = recentlyViewedAdapter
        }

        val cuisineName = listOf("Pizza", "Noodle", "Burger")
        val cuisineImage = listOf(R.drawable.pizza, R.drawable.noodle, R.drawable.burger)
        val browseByCuisineAdapter = BrowseByCuisineAdapter(cuisineName, cuisineImage)

        binding.browseByCuisineRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = browseByCuisineAdapter
        }

        val restaurantNameRecommended = listOf("iVegan", "Sando", "Colony Bakery")
        val ratingRecommended = listOf("5.0", "4.5", "4.0")
        val tagRecommended = listOf("Vegan", "Bakery", "Bakery")
        val restaurantImageRecommended = listOf(R.drawable.restaurant, R.drawable.restaurant2, R.drawable.restaurant3)
        val recommendedRestaurantAdapter = RecommendedRestaurantAdapter(restaurantNameRecommended, ratingRecommended, tagRecommended, restaurantImageRecommended)

        binding.recommendedRestaurantRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = recommendedRestaurantAdapter
        }

        val locationList: Array<String> = arrayOf("Kuala Lumpur", "Penang", "Johor", "Kelantan")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView: AutoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
