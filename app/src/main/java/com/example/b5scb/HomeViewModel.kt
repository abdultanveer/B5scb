package com.example.b5scb

import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    var data = 0

   fun incrementData(){
        data++
    }
}