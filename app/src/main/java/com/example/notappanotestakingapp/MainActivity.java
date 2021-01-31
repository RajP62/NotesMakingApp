package com.example.notappanotestakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    EditText etEnterData;
    Button btnMakeNote;
    TextView tvMainDataDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialisingViewsAndListeners();
        SharedPreferences getShared = getSharedPreferences("SharedData", MODE_PRIVATE);
        String recentData = getShared.getString("Str", "Please enter the text");
        tvMainDataDisplay.setText(recentData);
    }

    private void initialisingViewsAndListeners() {
        etEnterData = findViewById(R.id.et_EnterData);
        btnMakeNote = findViewById(R.id.btn_makeNote);
        tvMainDataDisplay = findViewById(R.id.Main_tvDisplayNotes);
        btnMakeNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEnterData.getText().toString().length() != 0) {
                    String Data = etEnterData.getText().toString();
                    SharedPreferences sharedPreferences = getSharedPreferences("SharedData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Str", Data);
                    editor.apply();
                    tvMainDataDisplay.setText(Data);
                    etEnterData.getText().clear();
                }
            }

        });

    }
}

