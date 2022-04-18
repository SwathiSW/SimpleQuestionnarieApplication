package com.example.simplequestionnarieapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simplequestionnarieapplication.ForgotPasswordDialog;
import com.example.simplequestionnarieapplication.R;
import com.example.simplequestionnarieapplication.database.UserDao;
import com.example.simplequestionnarieapplication.database.UserDatabase;
import com.example.simplequestionnarieapplication.database.UserEntity;


public class LoginActivity extends AppCompatActivity implements ForgotPasswordDialog.ExampleDialogListener {
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

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });
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
                    et_password.setError("Password is required");
                    et_password.requestFocus();
                    return;
                }
                if (password.length() < 6) {
                    et_password.setError("Min password length should be 6 characters!");
                    et_password.requestFocus();
                    return;
                } else {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.login(email, password);
                            //                           Log.d("userEntity",userEntity + " Entity");
                            if (userEntity == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                Toast.makeText(LoginActivity.this, "User Created!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            }
                        }
                    }).start();
                }
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
        ForgotPasswordDialog exampleDialog = new ForgotPasswordDialog();
        exampleDialog.show(getSupportFragmentManager(),"ExampleDialog");

    }

}