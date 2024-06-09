package com.example.fyp_rorm

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.example.fyp_rorm.FragmentRestaurant.BookingFragment
import com.example.fyp_rorm.FragmentRestaurant.DetailsFragment
import com.example.fyp_rorm.FragmentRestaurant.MenuFragment
import com.example.fyp_rorm.FragmentRestaurant.ReviewFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class RestaurantInfo : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_info)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val collapsingToolbar: CollapsingToolbarLayout = findViewById(R.id.collapsingToolbar)
        val appBarLayout: AppBarLayout = findViewById(R.id.appBar)

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (collapsingToolbar.height + verticalOffset <= 2 * ViewCompat.getMinimumHeight(collapsingToolbar)) {
                // Collapsed state
                supportActionBar?.setDisplayShowTitleEnabled(true)
            } else {
                // Expanded state
                supportActionBar?.setDisplayShowTitleEnabled(false)
            }
        })

        val imageViewDrawable: ImageView = findViewById(R.id.savedButton)
        imageViewDrawable.setOnClickListener {
            // Handle click on the drawable (if needed)
        }

        val ab: ActionBar? = supportActionBar
        ab?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_24)
        ab?.setDisplayHomeAsUpEnabled(true)

        drawerLayout = findViewById(R.id.drawer_layout)

        val navView: NavigationView = findViewById(R.id.navigation_view)
        if (navView != null) {
            setupDrawerContent(navView)
        }

        viewPager = findViewById(R.id.viewPager)
        if (viewPager != null) {
            setupViewPager(viewPager)
        }

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        setupImageSlider()
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(BookingFragment(), "Booking")
        adapter.addFrag(MenuFragment(), "Menu")
        adapter.addFrag(ReviewFragment(), "Review")
        adapter.addFrag(DetailsFragment(), "Details")
        viewPager.adapter = adapter
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true

            when (menuItem.itemId) {
                R.id.bookingFragment -> viewPager.currentItem = 0
                R.id.menuFragment -> viewPager.currentItem = 1
                R.id.reviewFragment -> viewPager.currentItem = 2
                R.id.detailsFragment -> viewPager.currentItem = 3
            }

            drawerLayout.closeDrawers()
            true
        }
    }

    private fun setupImageSlider() {
        val imageList = ArrayList<SlideModel>().apply {
            add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
            add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
            add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        }

        val imageSlider: ImageSlider = findViewById(R.id.imageSlider2)
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
    }

    class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFrag(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }
}