package com.example.simplequestionnarieapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    EditText et_email;
    EditText et_password;
    Button btn_login;
    Button btn_signIn;
    TextView tv_forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = (EditText) findViewById(R.id.et_email1);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
         btn_signIn = (Button) findViewById(R.id.btn_signIn);
         tv_forgotPassword = (TextView) findViewById(R.id.tv_forgotPassword);
//      Calling on sign_in button
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et_email.getText().toString().trim();
                String password = et_password.getText().toString().trim();

                // Validation Checking
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    et_email.setError("Please provide valid Email Address");
                    et_email.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    et_email.setError("Password is required");
                    et_password.requestFocus();
                    return;
                }
                if (password.length() < 6) {
                    et_email.setError("Min password length should be 6 characters!");
                    et_password.requestFocus();
                    return;
                }

            }
        });
        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Registration.class);
                startActivity(intent);
            }
        });
       tv_forgotPassword.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openDialog();
           }
       });
    }
    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"exampleDialog");

    }
    @Override
    public void applyText(String et_email1) {
        tv_forgotPassword.setText(et_email1);
    }
}