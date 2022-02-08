package com.example.firebasebooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

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
        GridLayout gridLayoutJaipur=findViewById(R.id.gridLayoutJaipur);
        GridLayout gridLayoutBanglore=findViewById(R.id.gridLayoutBanglore);
        Button buttonJ1 = findViewById(R.id.j1);
        Button buttonJ2 = findViewById(R.id.j2);
        Button buttonJ3 = findViewById(R.id.j3);
        Button buttonJ4 = findViewById(R.id.j4);
        Button buttonJ5 = findViewById(R.id.j5);
        Button buttonJ6 = findViewById(R.id.j6);
        Button buttonB1 = findViewById(R.id.b1);
        Button buttonB2 = findViewById(R.id.b2);
        Button buttonB3 = findViewById(R.id.b3);
        Button buttonB4 = findViewById(R.id.b4);
        Button buttonB5 = findViewById(R.id.b5);
        Button buttonB6 = findViewById(R.id.b6);

        gridLayoutBanglore.setVisibility(View.GONE);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    gridLayoutJaipur.setVisibility(View.GONE);
                    gridLayoutBanglore.setVisibility(View.VISIBLE);
                } else {
                    gridLayoutJaipur.setVisibility(View.VISIBLE);
                    gridLayoutBanglore.setVisibility(View.GONE);
                }
            }
        });


    }
}