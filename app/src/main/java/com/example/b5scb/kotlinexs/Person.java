package com.example.b5scb.kotlinexs;

import com.example.b5scb.kotlinexs.AddLongCallback;

public class Person {

    int add(int fno,int sno){
        return  fno + sno;
    }

    void addLong(long a, long b, AddLongCallback callback){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        callback.onSuccess(a+b);
    }

    String getWeather(String cityName){
        return "{temp:30, wind : 40kmph}";
    }
}

//https://abdul.com/a=10,b=20,m=add
//{ result: 30 }
//https://abdul.com/getweather/city=bangalore
