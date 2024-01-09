package com.example.b5scb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView dataTv;
    HomeViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Student annsari = new Student("abdul",321,false,87654321);
        annsari.getName();
         dataTv = findViewById(R.id.tvData);
        //ViewModelProvider(this).get(HomeViewModel::class.java)
         viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
         //get the inntent  which started this activity
        //String data = getIntent().getStringExtra("nkey");
        dataTv.setText(""+viewModel.getData());
    }

    public void increment(View view) {
        viewModel.incrementData();
        dataTv.setText(""+viewModel.getData());

       /* data++;
        dataTv.setText(""+data);*/
    }
}