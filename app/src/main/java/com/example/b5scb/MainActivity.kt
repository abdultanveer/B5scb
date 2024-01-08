package com.example.b5scb

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//compat -- backwards compatibility
class MainActivity : AppCompatActivity() {
    //EditText nameEt;
    lateinit var nameEt:EditText
    lateinit var submitBtn:Button
    lateinit var statusTv:TextView


   // var TAG = "MainActivity"
    var TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameEt = findViewById(R.id.etName) //taking handle
        submitBtn = findViewById(R.id.btnSubmmit)
        statusTv = findViewById(R.id.tvStatus)
        Log.i(TAG,"activity is created")
    }


    override fun onStart() {
        super.onStart()
        Log.e(TAG,"activity is started")

    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG,"activity is resumed")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"activity is paused")

    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG,"activity is stopped")

    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG,"activity is restarted")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"activity is destroyed")

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

        add(10,20)
        var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876512345"))
        startActivity(dIntent)
        throw NullPointerException("debug demo")
    }

    private fun add(i: Int, i1: Int):Int {
        var c = i +i1
        var d = c *10
        return  c +d

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