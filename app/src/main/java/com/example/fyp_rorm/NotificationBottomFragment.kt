package com.example.fyp_rorm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp_rorm.adapter.NotificationAdapter
import com.example.fyp_rorm.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NotificationBottomFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBottomBinding.inflate(inflater, container, false)

        val notifications = listOf(
            "Your reservation has been Canceled Successfully",
            "Congrats! Your reservation has been Confirmed Successfully",
            "Congrats! Your preorder has been Confirmed Successfully"
        )
        val notificationImages = listOf(
            R.drawable.cancel,
            R.drawable.confirm,
            R.drawable.confirm
        )

        val adapter = NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationImages)
        )
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = adapter

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = NotificationBottomFragment()
    }
}
