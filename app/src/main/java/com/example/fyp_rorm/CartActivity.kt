package com.example.fyp_rorm

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp_rorm.adapter.CartAdapter
import com.example.fyp_rorm.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantName = listOf("iVegan", "Sando")
        val quantity = listOf("1 item", "2 items")
        val restaurantImage = listOf(
            R.drawable.restaurant,
            R.drawable.restaurant2
        )

        val adapter = CartAdapter(ArrayList(restaurantName), ArrayList(quantity), ArrayList(restaurantImage))
        binding.cartRestaurantRecycleView.layoutManager = LinearLayoutManager(this)
        binding.cartRestaurantRecycleView.adapter = adapter


        // Set an OnClickListener on the backButton
        binding.actionBar.root.findViewById<ImageView>(R.id.backButton).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()  // Optional: Finish the current activity
        }

    }
}
