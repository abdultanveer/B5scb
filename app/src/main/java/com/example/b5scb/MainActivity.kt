package com.example.b5scb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //EditText nameEt;
    lateinit var nameEt:EditText
    lateinit var submitBtn:Button
    lateinit var statusTv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameEt = findViewById(R.id.etName)
        submitBtn = findViewById(R.id.btnSubmmit)
        statusTv = findViewById(R.id.tvStatus)
    }

    fun handleClick(mview: View) {

        var  name:String = nameEt.text.toString()
        statusTv.text = name
    }
}