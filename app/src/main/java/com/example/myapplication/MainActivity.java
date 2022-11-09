package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText dpDate;
    EditText etNumber;
    EditText etAddress;
    EditText etEmail;
    Button btnNama;
    DatePickerDialog datePickerDialog;


    public final static String MESSAGE_KEY = "com.example.myapplication.message_key";
    public final static String MESSAGE_DATE = "com.example.myapplication.message_date";
    public final static String MESSAGE_PHONE = "com.example.myapplication.message_phone";
    public final static String MESSAGE_ADDRESS = "com.example.myapplication.message_address";
    public final static String MESSAGE_EMAIL = "com.example.myapplication.message_email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();
        // initiate the date picker and a button
        dpDate = (EditText) findViewById(R.id.dpDate);
        // perform click event on edit text
        dpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                dpDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

    }

    public void sendData(View view) {
        etNama = findViewById(R.id.etNama);
        dpDate = findViewById(R.id.dpDate);
        etNumber = findViewById(R.id.etNumber);
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);


        btnNama = findViewById(R.id.btnNama);

        String message = etNama.getText().toString();
        String message1 = dpDate.getText().toString();
        String message2 = etNumber.getText().toString();
        String message3 = etAddress.getText().toString();
        String message4 = etEmail.getText().toString();


        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        if (!message4.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(message4).matches()) {
            intent.putExtra(MESSAGE_KEY, message);
            intent.putExtra(MESSAGE_DATE, message1);
            intent.putExtra(MESSAGE_PHONE, message2);
            intent.putExtra(MESSAGE_ADDRESS, message3);
            intent.putExtra(MESSAGE_EMAIL, message4);
            startActivity(intent);
        }
        else if (etEmail.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter your email!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Invalid email address!", Toast.LENGTH_SHORT).show();
        }
    }
    private EditText email;

    private String valid_email;

    /**
     * This method is used to initialize UI Components
     */
    private void initializeUI() {
        // TODO Auto-generated method stub

        email = (EditText) findViewById(R.id.etEmail);

        email.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                // TODO Auto-generated method stub
                Is_Valid_Email(email); // pass your EditText Obj here.
            }

            public void Is_Valid_Email(EditText edt) {
                if (edt.getText().toString() == null) {
                    edt.setError("Invalid Email Address!");
                    valid_email = null;
                } else if (isEmailValid(edt.getText().toString()) == false) {
                    edt.setError("Invalid Email Address");
                    valid_email = null;
                } else {
                    valid_email = edt.getText().toString();
                }
            }

            boolean isEmailValid(CharSequence email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            } // end of TextWatcher (email)
        });

    }

}