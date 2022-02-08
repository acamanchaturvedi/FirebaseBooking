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
        list.add("6AM-7AM_J");
        list.add("7AM-8AM_J");
        list.add("8AM-9AM_J");
        list.add("5PM-6PM_J");
        list.add("6PM-7PM_J");
        list.add("7PM-8PM_J");
        list.add("6AM-7AM_B");
        list.add("7AM-8AM_B");
        list.add("8AM-9AM_B");
        list.add("5PM-6PM_B");
        list.add("6PM-7PM_B");
        list.add("7PM-8PM_B");
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