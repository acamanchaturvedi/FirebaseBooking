package com.example.firebasebooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReportingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporting);

        ListView slotsListView = findViewById(R.id.slotsListView);
        ArrayList<String> list = new ArrayList<>();
        list.add("6:00AM-7:30AM_J");
        list.add("7:30AM-9:00AM_J");
        list.add("5:00PM-6:30PM_J");
        list.add("6:30PM-8:00PM_J");
        list.add("6:00AM-7:30AM_B");
        list.add("7:30AM-9:00AM_B");
        list.add("5:00PM-6:30PM_B");
        list.add("6:30PM-8:00PM_B");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        slotsListView.setAdapter(adapter);

        slotsListView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(ReportingActivity.this,ReportsActivity.class);
            String  slotName=list.get(i).toString();
            intent.putExtra("slotName",slotName);
            //Toast.makeText(this, slotName, Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
}