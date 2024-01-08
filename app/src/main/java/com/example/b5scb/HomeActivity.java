package com.example.b5scb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView dataTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         dataTv = findViewById(R.id.tvData);
         //get the inntent  which started this activity
        String data = getIntent().getStringExtra("nkey");
        dataTv.setText(data);
    }
}