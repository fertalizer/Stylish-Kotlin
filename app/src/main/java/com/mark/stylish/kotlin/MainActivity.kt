package com.mark.stylish.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mark.stylish.kotlin.databinding.ActivityMainBinding
import com.mark.stylish.kotlin.factory.ViewModelFactory

class MainActivity : AppCompatActivity() {
    // Derived from the name of layout file.
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // Replace setContentView

        viewModelFactory = ViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

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
                // use safe-args navigation
                findNavController(R.id.myNavHostFragment).navigate(NavigationDirections.actionGlobalHomeFragment())
                toolbarLogoVisible()
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottom_navigation_catalog -> {
                findNavController(R.id.myNavHostFragment).navigate(NavigationDirections.actionGlobalCatalogFragment())
                toolbarTitleVisible("型錄")
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottom_navigation_cart -> {
                findNavController(R.id.myNavHostFragment).navigate(NavigationDirections.actionGlobalCartFragment())
                toolbarTitleVisible("購物車")
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottom_navigation_profile -> {
                findNavController(R.id.myNavHostFragment).navigate(NavigationDirections.actionGlobalProfileFragment())
                toolbarTitleVisible("個人")
                return@OnNavigationItemSelectedListener true
            }
            else -> false
        }
    }

    fun setupBottomNavigation() {
        binding.bottomNav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    fun toolbarTitleVisible(title: String) {
        binding.textToolbarTitle.visibility = View.VISIBLE
        binding.textToolbarTitle.text = title
        binding.imageToolbarLogo.visibility = View.GONE
    }

    fun toolbarLogoVisible() {
        binding.textToolbarTitle.visibility = View.GONE
        binding.textToolbarTitle.text = ""
        binding.imageToolbarLogo.visibility = View.VISIBLE
    }

}