package com.example.b5scb

import android.app.Application
import com.example.b5scb.data.ItemRoomDatabase

class InventoryApplication : Application(){
    val database: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }
}