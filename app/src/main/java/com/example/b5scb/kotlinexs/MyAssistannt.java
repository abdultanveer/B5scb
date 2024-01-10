package com.example.b5scb.kotlinexs;

import android.util.Log;

public class MyAssistannt implements AddLongCallback{

    @Override
    public void onSuccess(long result) {
        Log.i("result received =",result+"");

    }
}
