package com.example.notappanotestakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_ChooseBWTwoOptions extends AppCompatActivity {
    private Button btnMakeNewTask, btnScheduleNextDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__choose_b_w_two_options);
        btnMakeNewTask = findViewById(R.id.btnMakeNewTask);
        btnScheduleNextDay = findViewById(R.id.btnScheduleNextDay);
        onBtnMakeNewTask();
        onBtnScheduleNextDay();
    }
    private void onBtnMakeNewTask(){
        btnMakeNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_ChooseBWTwoOptions.this,MainActivity.class));
            }
        });

    }
    private void onBtnScheduleNextDay(){
        btnScheduleNextDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(Activity_ChooseBWTwoOptions.this,));
            }
        });
    }
}