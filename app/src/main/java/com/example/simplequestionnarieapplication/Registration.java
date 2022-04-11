package com.example.simplequestionnarieapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    TextView tv_registrationPage;
    EditText et_Email,et_Password,et_confirmPassword,et_Phone,et_streetName,et_city,et_state,et_zipcode;
    Button btn_register;
    Spinner spinner;
    TextView tv_forgotPassword,tv_regLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        tv_registrationPage = (TextView) findViewById(R.id.tv_registrationPage);
        et_Email = (EditText) findViewById(R.id.et_Email);
        et_Password = (EditText) findViewById(R.id.et_Password);
        et_confirmPassword = (EditText) findViewById(R.id.et_confirmPassword);
        et_Phone = (EditText) findViewById(R.id.et_Phone);
        et_streetName = (EditText) findViewById(R.id.et_streetName);
        et_city = (EditText) findViewById(R.id.et_city);
        et_state = (EditText) findViewById(R.id.et_state);
        et_zipcode = (EditText) findViewById(R.id.et_zipcode);
        tv_forgotPassword = (TextView) findViewById(R.id.tv_forgotPassword);
        tv_regLogin = (TextView) findViewById(R.id.tv_regLogin);
        spinner = (Spinner) findViewById(R.id.spinner);
        btn_register = (Button) findViewById(R.id.btn_register);

        tv_forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
    }
}