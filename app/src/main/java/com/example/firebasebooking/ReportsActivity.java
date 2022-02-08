package com.example.firebasebooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        String slotName;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                slotName= null;
            } else {
                slotName= extras.getString("slotName");
            }
        } else {
            slotName= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }
        Toast.makeText(this, slotName, Toast.LENGTH_SHORT).show();

        ListView reportsListView = findViewById(R.id.reportsListView);
        ArrayList<String> slotEmployees = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,slotEmployees);
        reportsListView.setAdapter(adapter);

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("slots").child(slotName);

/*        database = FirebaseDatabase.getInstance();
        root = database.getReference();
        slots=root.child("slots");*/

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                slotEmployees.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    slotEmployees.add(snapshot.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}