package com.mark.stylish.kotlin.catalog

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mark.stylish.kotlin.R
import com.mark.stylish.kotlin.databinding.CartFragmentBinding
import com.mark.stylish.kotlin.databinding.CatalogFragmentBinding
import com.mark.stylish.kotlin.databinding.HomeFragmentBinding

class CatalogFragment : Fragment() {

    private lateinit var viewModel: CatalogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val binding: CatalogFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.catalog_fragment, container, false)
        val binding = CatalogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CatalogViewModel::class.java)
        // TODO: Use the ViewModel
    }

}