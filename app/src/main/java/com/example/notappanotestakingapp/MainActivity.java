package com.example.notappanotestakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    EditText etEnterData;
    Button btnMakeNote;
    ListView listView;

    DatabaseHelper databaseHelper;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEnterData = findViewById(R.id.et_EnterData);
        btnMakeNote = findViewById(R.id.btn_makeNote);
        listView = findViewById(R.id.ListView_AddDays_AfterMakeNewTask);
//        initialise database helper
        databaseHelper = new DatabaseHelper(MainActivity.this);
//        add database values to ArrayList
        arrayList = databaseHelper.getALlText();
//        initialise ArrayAdapter
        arrayAdapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,arrayList);

//        Set ArrayAdapter
        listView.setAdapter(arrayAdapter);

        btnMakeNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Get text from editText
                String text = etEnterData.getText().toString();
                if(!text.isEmpty()){
                    if(databaseHelper.addText(text)){
                        etEnterData.setText("");//clear EditText
                        Toast.makeText(getApplicationContext(),"Data Inserted Successfully"
                                ,Toast.LENGTH_SHORT).show();
//                        clear ArrayList
                        arrayList.clear();
                        arrayList.addAll(databaseHelper.getALlText());
//                        Refresh ListView Data
                        arrayAdapter.notifyDataSetChanged();
                        listView.invalidateViews();
                        listView.refreshDrawableState();
                    }
                }
            }
        });


    }
}

