package com.example.b5scb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.b5scb.databinding.ActivityHomeBinding;
import com.example.b5scb.kotlinexs.MyAssistannt;
import com.example.b5scb.kotlinexs.Person;
import com.example.b5scb.kotlinexs.Student;
import com.example.b5scb.ui.dashboard.HomeViewModel;

public class HomeActivity extends AppCompatActivity {

   // TextView dataTv;
    //3 deeclaratipons
    HomeViewModel viewModel;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        // setContentView(R.layout.activity_home);
        Student annsari = new Student("abdul",321,false,87654321);
        annsari.getName();
       //  dataTv = findViewById(R.id.tvData);
         //3 inits
        //ViewModelProvider(this).get(HomeViewModel::class.java)
         viewModel = new ViewModelProvider(this).get(HomeViewModel.class);


        Observer<Integer>  secsObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
               binding. tvData.setText(integer.toString());
            }
        };

        viewModel.seconds().observe(this, secsObserver);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Person myPerson = new Person();
       /*int c = myPerson.add(10,20);
        MyAssistannt myAssistannt = new MyAssistannt();
        myPerson.addLong(100l,200l,myAssistannt);*/
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tvFirst.setText("through view binding");
                binding.checkBox.setChecked(true);
            }
        });
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