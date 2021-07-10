package com.example.ntest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ntest.model.Ndata1
import com.example.ntest.model.Ndatas
import com.example.ntest.netservice.ApiRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val apiRepository: ApiRepository) : ViewModel() {
    val nData = MutableLiveData<Ndatas>()

    fun requestApi(page: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            apiRepository.getList(page)?.let { response ->
                if(response.isSuccessful){
                    response.body()?.let {
                        nData.postValue(it)
                    }
                }
            }
        }
    }
}