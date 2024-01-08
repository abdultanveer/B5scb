package com.example.b5scb

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
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
        nameEt = findViewById(R.id.etName) //taking handle
        submitBtn = findViewById(R.id.btnSubmmit)
        statusTv = findViewById(R.id.tvStatus)
    }

    fun handleClick(mview: View) {

        var  name:String = nameEt.text.toString()
        statusTv.text = name
    }

    fun launchHome(view: View) {
        //Intent homeIntent = new Intent();
        var data = nameEt.text.toString()
        var homeIntent:Intent = Intent(this,HomeActivity::class.java)
        homeIntent.putExtra("nkey",data)
        startActivity(homeIntent)
    }

    fun openDialer(view: View) {
        var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876512345"))
        startActivity(dIntent)
    }



    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
      //  if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
       // }
    }

    fun setAlarm(view: View) {
        createAlarm("b5 anndroid",12,4)
    }
}