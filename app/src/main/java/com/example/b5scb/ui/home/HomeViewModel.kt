package com.example.b5scb.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.b5scb.network.MarsApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _status = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _status


     fun getMarsPhotos() {
        viewModelScope.launch {
            val listResult = MarsApi.retrofitService.getPhotos()
            _status.value = listResult

        }
    }
}