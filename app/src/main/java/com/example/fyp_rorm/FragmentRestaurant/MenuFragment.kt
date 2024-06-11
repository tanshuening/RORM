package com.example.fyp_rorm.FragmentRestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp_rorm.R
import com.example.fyp_rorm.adapter.MenuItemAdapter
import com.example.fyp_rorm.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var menuItemAdapter: MenuItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val menuItemName = arrayListOf(
            "Pizza",
            "Burger",
            "Pasta",
            "Pizza",
            "Burger",
            "Pasta",
            "Pizza",
            "Burger",
            "Pasta"
        )
        val menuItemPrice = arrayListOf(
            "10.00",
            "15.00",
            "20.00",
            "10.00",
            "15.00",
            "20.00",
            "10.00",
            "15.00",
            "20.00"
        )
        val menuItemImage = arrayListOf(
            R.drawable.pizza,
            R.drawable.burger,
            R.drawable.noodle,
            R.drawable.pizza,
            R.drawable.burger,
            R.drawable.noodle,
            R.drawable.pizza,
            R.drawable.burger,
            R.drawable.noodle
        )

        menuItemAdapter = MenuItemAdapter(menuItemName, menuItemImage, menuItemPrice)

        binding.menuItemRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.menuItemRecyclerView.adapter = menuItemAdapter
    }

    companion object {

    }

}
