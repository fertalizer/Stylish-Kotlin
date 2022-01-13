package com.mark.stylish.kotlin.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mark.stylish.kotlin.MainViewModel
import com.mark.stylish.kotlin.R
import com.mark.stylish.kotlin.data.HomeItem
import com.mark.stylish.kotlin.data.Product
import com.mark.stylish.kotlin.databinding.HomeFragmentBinding
import com.mark.stylish.kotlin.factory.ViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val binding: HomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        val binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        viewModelFactory = ViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        binding.viewModel = viewModel
        val adapter = HomeAdapter()
        binding.recyclerHome.adapter = adapter

        val list = mockData()
        adapter.submitList(list)

        return binding.root
    }

    fun mockData(): List<HomeItem> {
        val homeItems = mutableListOf<HomeItem>()

        val homeTitle = HomeItem.HomeTitle("Stylish Test")

        homeItems.add(homeTitle)

        return homeItems
    }
}