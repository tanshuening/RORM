package com.example.fyp_rorm.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
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

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object: ItemClickListener {
            override fun doubleClick(position: Int) {
                // Implement double click action if needed
            }

            override fun onItemSelected(position: Int) {
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })

        val restaurantName = listOf("iVegan", "Sando", "Colony Bakery")
        val rating = listOf("5.0", "4.5", "4.0")
        val tag = listOf("Vegan", "Bakery", "Bakery")
        val restaurantImage = listOf(R.drawable.restaurant, R.drawable.restaurant2, R.drawable.restaurant3)
        val recentlyViewedAdapter = RecentlyViewedRestaurantAdapter(restaurantName, rating, tag, restaurantImage)

        binding.recentlyViewedRecycleView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recentlyViewedRecycleView.adapter = recentlyViewedAdapter

        val cuisineName = listOf("Pizza", "Noodle", "Burger")
        val cuisineImage = listOf(R.drawable.pizza, R.drawable.noodle, R.drawable.burger)
        val browseByCuisineAdapter = BrowseByCuisineAdapter(cuisineName, cuisineImage)

        binding.browseByCuisineRecycleView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.browseByCuisineRecycleView.adapter = browseByCuisineAdapter

        val restaurantNameRecommended = listOf("iVegan", "Sando", "Colony Bakery")
        val ratingRecommended = listOf("5.0", "4.5", "4.0")
        val tagRecommended = listOf("Vegan", "Bakery", "Bakery")
        val restaurantImageRecommended = listOf(R.drawable.restaurant, R.drawable.restaurant2, R.drawable.restaurant3)
        val recommendedRestaurantAdapter = RecommendedRestaurantAdapter(restaurantNameRecommended, ratingRecommended, tagRecommended, restaurantImageRecommended)

        binding.recommendedRestaurantRecycleView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recommendedRestaurantRecycleView.adapter = recommendedRestaurantAdapter
    }

    companion object {

    }
}
