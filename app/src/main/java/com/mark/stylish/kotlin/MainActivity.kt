package com.mark.stylish.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.mark.stylish.kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Derived from the name of layout file.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // Replace setContentView

        setToolbar()
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

    fun setToolbar() {
        binding.toolbar.setPadding(0, statusBarHeight, 0, 0)
    }


}