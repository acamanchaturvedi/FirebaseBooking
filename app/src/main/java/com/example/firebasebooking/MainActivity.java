package com.example.firebasebooking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button buttonJ1;
    Button buttonJ2;
    Button buttonJ3;
    Button buttonJ4;
    Button buttonB1;
    Button buttonB2;
    Button buttonB3;
    Button buttonB4;

    public void book(View view) {
        Button b=(Button)view;
        String buttonId= String.valueOf(view.getTag());
        String buttonText =b.getText().toString();
        Intent intent=new Intent(MainActivity.this,BookingActivity.class);
        intent.putExtra("id",buttonId);
        intent.putExtra("slot",buttonText);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch mySwitch = findViewById(R.id.reminder);
        LinearLayout linearLayoutJaipur=findViewById(R.id.linearLayoutJaipur);
        LinearLayout linearLayoutBanglore=findViewById(R.id.linearLayoutBanglore);
        buttonJ1 = findViewById(R.id.j1);
        buttonJ2 = findViewById(R.id.j2);
        buttonJ3 = findViewById(R.id.j3);
        buttonJ4 = findViewById(R.id.j4);
        buttonB1 = findViewById(R.id.b1);
        buttonB2 = findViewById(R.id.b2);
        buttonB3 = findViewById(R.id.b3);
        buttonB4 = findViewById(R.id.b4);

        Button reportsButton = findViewById(R.id.reportsButton);
        reportsButton.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,ReportingActivity.class));
        });

        linearLayoutBanglore.setVisibility(View.GONE);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    linearLayoutJaipur.setVisibility(View.GONE);
                    linearLayoutBanglore.setVisibility(View.VISIBLE);
                } else {
                    linearLayoutJaipur.setVisibility(View.VISIBLE);
                    linearLayoutBanglore.setVisibility(View.GONE);
                }
            }
        });

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("slots");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                //Toast.makeText(MainActivity.this,dataSnapshot.getKey()+"_"+dataSnapshot.getChildrenCount() , Toast.LENGTH_SHORT).show();
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:00AM-7:30AM_J")) {
                    buttonJ1.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("7:30AM-9:00AM_J")) {
                    buttonJ2.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("5:00PM-6:30PM_J")) {
                    buttonJ3.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:30PM-8:00PM_J")) {
                    buttonJ4.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:00AM-7:30AM_B")) {
                    buttonB1.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("7:30AM-9:00AM_B")) {
                    buttonB2.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("5:00PM-6:30PM_B")) {
                    buttonB3.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:30PM-8:00PM_B")) {
                    buttonB4.setEnabled(false);
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("slots");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                //Toast.makeText(MainActivity.this,dataSnapshot.getKey()+"_"+dataSnapshot.getChildrenCount() , Toast.LENGTH_SHORT).show();
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:00AM-7:30AM_J")) {
                    buttonJ1.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("7:30AM-9:00AM_J")) {
                    buttonJ2.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("5:00PM-6:30PM_J")) {
                    buttonJ3.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:30PM-8:00PM_J")) {
                    buttonJ4.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:00AM-7:30AM_B")) {
                    buttonB1.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("7:30AM-9:00AM_B")) {
                    buttonB2.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("5:00PM-6:30PM_B")) {
                    buttonB3.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:30PM-8:00PM_B")) {
                    buttonB4.setEnabled(false);
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("slots");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                //Toast.makeText(MainActivity.this,dataSnapshot.getKey()+"_"+dataSnapshot.getChildrenCount() , Toast.LENGTH_SHORT).show();
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:00AM-7:30AM_J")) {
                    buttonJ1.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("7:30AM-9:00AM_J")) {
                    buttonJ2.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("5:00PM-6:30PM_J")) {
                    buttonJ3.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:30PM-8:00PM_J")) {
                    buttonJ4.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:00AM-7:30AM_B")) {
                    buttonB1.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("7:30AM-9:00AM_B")) {
                    buttonB2.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("5:00PM-6:30PM_B")) {
                    buttonB3.setEnabled(false);
                }
                if(dataSnapshot.getChildrenCount()==5&&dataSnapshot.getKey().equals("6:30PM-8:00PM_B")) {
                    buttonB4.setEnabled(false);
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}