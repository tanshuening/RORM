package com.example.fyp_rorm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.fyp_rorm.adapter.MenuItemAdapter
import com.example.fyp_rorm.databinding.ActivityRestaurantInfoBinding

class RestaurantInfo : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider2
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                // Implement double click action if needed
            }

            override fun onItemSelected(position: Int) {
                val itemMessage = "Selected Image $position"
                Toast.makeText(this@RestaurantInfo, itemMessage, Toast.LENGTH_SHORT).show()
            }
        })

        val menuItemName = listOf("Pizza", "Noodle", "Burger")
        val menuItemPrice = listOf("RM 20.00", "RM 15.00", "RM 10.00")
        val menuItemImage = listOf(R.drawable.pizza, R.drawable.noodle, R.drawable.burger)
        val menuItemAdapter = MenuItemAdapter(menuItemName, menuItemImage, menuItemPrice)

        binding.menuItemRecycleView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.menuItemRecycleView.adapter = menuItemAdapter
    }

    companion object {

    }
}
