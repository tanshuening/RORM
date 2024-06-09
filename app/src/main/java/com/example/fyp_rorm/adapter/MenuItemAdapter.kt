package com.example.fyp_rorm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp_rorm.databinding.RestaurantMenuBinding

class MenuItemAdapter(
    private val menuNames: ArrayList<String>,
    private val images: ArrayList<Int>,
    private val prices: ArrayList<String>
) : RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val binding = RestaurantMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        val menuName = menuNames[position]
        val image = images[position]
        val price = prices[position]
        holder.bind(menuName, image, price)
    }

    override fun getItemCount(): Int {
        return menuNames.size
    }

    class MenuItemViewHolder(private val binding: RestaurantMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(menuName: String, image: Int, price: String) {
            binding.menuItemName.text = menuName
            binding.menuItemPrice.text = price
            binding.menuItemImage.setImageResource(image)
        }
    }
}
