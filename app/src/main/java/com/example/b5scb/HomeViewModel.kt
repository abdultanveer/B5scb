package com.example.b5scb

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    var TAG = HomeViewModel::class.java.simpleName
    var data = 0
    lateinit var timer: CountDownTimer
    private  val _seconds = MutableLiveData<Int>()


    //timer, updated, textview in activity shud receive  the updates

   fun incrementData(){
        data++
    }

    fun seconds(): LiveData<Int> {
        return _seconds
    }
    fun startTime() {
        timer = object : CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                _seconds.value = millisUntilFinished.toInt()
                Log.i(TAG,"time left = "+millisUntilFinished.toInt())
            }

            override fun onFinish() {
                Log.i(TAG, "timer  finished")
            }
        }.start()

        }
    }