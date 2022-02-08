package com.example.firebasebooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookingActivity extends AppCompatActivity {

    EditText etLoginName;
    protected String name,id,slot;

    FirebaseDatabase database;
    DatabaseReference root,slots;

    public void bookButton(View view) {
        name+=etLoginName.getText().toString();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        DataHolder dataHolder=new DataHolder(name,"taylor.swift@intimetec.com",id,"13dec1989");

        slots.child(slot).push().setValue(dataHolder);
        //todo call internt ASAP important

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        slot=intent.getStringExtra("slot");
        TextView locationTextView= findViewById(R.id.locationTextView);
        TextView slotTextView = findViewById(R.id.slotTextView);
        String temp1="office location: "+id;
        locationTextView.setText(temp1);
        String temp2="slot timings: "+slot;
        slotTextView.setText(temp2);
        etLoginName=findViewById(R.id.etLoginName);
        name="";

        database = FirebaseDatabase.getInstance();
        root = database.getReference();
        slots=root.child("slots");

    }
}