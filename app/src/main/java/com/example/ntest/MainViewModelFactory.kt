package com.example.ntest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ntest.netservice.ApiRepository

class MainViewModelFactory(private val apiRepository: ApiRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ApiRepository::class.java).newInstance(apiRepository)
    }
}