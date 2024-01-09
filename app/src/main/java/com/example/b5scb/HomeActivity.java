package com.example.b5scb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
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
       // dataTv.setText(""+viewModel.getData());
     /*   final Observer nameObserver = new Observer() {
            @Override
            public void onChanged(@Nullable final int secs) {
                // Update the UI, in this case, a TextView.
                dataTv.setText(""+secs);
            }
        };*/

        Observer<Integer>  secsObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                dataTv.setText(integer.toString());
            }
        };

        viewModel.seconds().observe(this, secsObserver);
    }

    public void increment(View view) {
        //viewModel.incrementData();

                //viewModel.getData());
        viewModel.startTime();
       // dataTv.setText(""+viewModel.get_seconds());

       /* data++;
        dataTv.setText(""+data);*/
    }
}