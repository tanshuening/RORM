package com.example.fyp_rorm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp_rorm.databinding.CartRestaurantBinding

class CartAdapter(
    private val restaurantNameCart: MutableList<String>,
    private val quantityMenuItemCart: MutableList<String>,
    private val restaurantImageCart: MutableList<Int>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = restaurantNameCart.size

    inner class CartViewHolder(private val binding: CartRestaurantBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                restaurantName.text = restaurantNameCart[position]
                quantity.text = quantityMenuItemCart[position]
                restaurantImage.setImageResource(restaurantImageCart[position])
            }
        }
    }
}
