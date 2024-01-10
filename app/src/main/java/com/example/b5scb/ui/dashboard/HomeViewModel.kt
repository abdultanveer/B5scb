package com.example.b5scb.ui.dashboard

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.b5scb.data.Item
import com.example.b5scb.data.ItemDao
import kotlinx.coroutines.launch

class HomeViewModel(private val itemDao: ItemDao): ViewModel() {
    var TAG = HomeViewModel::class.java.simpleName
    var data = 0
    lateinit var timer: CountDownTimer
    private  val _seconds = MutableLiveData<Int>()



     fun insertItem(item: Item) {
         var a =10
        viewModelScope.launch {
            itemDao.insert(item)
        }
    }

    fun retrieveItem(id: Int): LiveData<Item> {
        return itemDao.getItem(id).asLiveData()

    }


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

//this factory produces homeview model object
class HomeViewModelFactory(private val itemDao: ItemDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return HomeViewModel(itemDao) as T    }
}

