package com.mark.stylish.kotlin.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mark.stylish.kotlin.MainViewModel
import com.mark.stylish.kotlin.home.HomeViewModel

class ViewModelFactory constructor(): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            with(modelClass) {
                when {
                    isAssignableFrom(MainViewModel::class.java) ->
                        MainViewModel()

                    isAssignableFrom(HomeViewModel::class.java) ->
                        HomeViewModel()

                    else ->
                        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")

                }
            } as T
}