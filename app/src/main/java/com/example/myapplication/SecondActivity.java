package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvOutput, tvOutput1, tvOutput2, tvOutput3, tvOutput4;

    public final static String MESSAGE_KEY = "com.example.myapplication.message_key";
    public final static String MESSAGE_DATE = "com.example.myapplication.message_date";
    public final static String MESSAGE_PHONE = "com.example.myapplication.message_phone";
    public final static String MESSAGE_ADDRESS = "com.example.myapplication.message_address";
    public final static String MESSAGE_EMAIL = "com.example.myapplication.message_email";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MESSAGE_KEY);
        String message1 = intent.getStringExtra(MESSAGE_DATE);
        String message2 = intent.getStringExtra(MESSAGE_PHONE);
        String message3 = intent.getStringExtra(MESSAGE_ADDRESS);
        String message4 = intent.getStringExtra(MESSAGE_EMAIL);

        tvOutput = (findViewById(R.id.tvName));
        tvOutput.setText("Nama : "+message);

        tvOutput1 = (findViewById(R.id.tvDate));
        tvOutput1.setText("\nTarikh Lahir : "+message1);

        tvOutput2 = (findViewById(R.id.tvPhone));
        tvOutput2.setText("\nNombor Telefon : "+message2);

        tvOutput3 = (findViewById(R.id.tvAddress));
        tvOutput3.setText("\nAlamat : "+message3);

        tvOutput4 = (findViewById(R.id.tvEmail));
        tvOutput4.setText("\nEmel : "+message4);

    }


}