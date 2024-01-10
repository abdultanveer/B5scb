package com.example.b5scb;

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
}
