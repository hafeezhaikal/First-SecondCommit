package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    Button btnNama;
    public final static String MESSAGE_KEY = "com.example.myapplication.message_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(View view){
        etNama = findViewById(R.id.etNama);
        btnNama = findViewById(R.id.btnNama);
        String message = etNama.getText().toString();
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra(MESSAGE_KEY,message);
        startActivity(intent);
    }
}