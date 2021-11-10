package com.mark.stylish.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mark.stylish.kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Derived from the name of layout file.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // Replace setContentView
        setupToolbar()
        setupBottomNavigation()
    }

    // get the height of status bar from system
    private val statusBarHeight: Int
        get() {
            val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
            return when {
                resourceId > 0 -> resources.getDimensionPixelSize(resourceId)
                else -> 0
            }
        }

    fun setupToolbar() {
        binding.toolbar.setPadding(0, statusBarHeight, 0, 0)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        when(item.itemId) {
            R.id.bottom_navigation_home -> {
                findNavController(R.id.myNavHostFragment).navigate(R.id.homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottom_navigation_catalog -> {
                findNavController(R.id.myNavHostFragment).navigate(R.id.catalogFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottom_navigation_cart -> {
                findNavController(R.id.myNavHostFragment).navigate(R.id.cartFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottom_navigation_profile -> {
                findNavController(R.id.myNavHostFragment).navigate(R.id.profileFragment)
                return@OnNavigationItemSelectedListener true
            }
            else -> false
        }
    }

    fun setupBottomNavigation() {
        binding.bottomNav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

}