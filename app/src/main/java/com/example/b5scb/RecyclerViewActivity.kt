package com.example.b5scb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RecyclerViewActivity : AppCompatActivity() {

    var languages = arrayOf("english","hindi","urdu","kannada","tamil","telgu","malyalam")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
    }
}