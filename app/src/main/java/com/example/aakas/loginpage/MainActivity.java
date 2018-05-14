package com.example.aakas.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView user_registration;
    private EditText email;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user_registration = (TextView)findViewById(R.id.tvRegister);
        email = (EditText) findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPassword);
        info = (TextView) findViewById(R.id.tvWarning);
        login = (Button) findViewById(R.id.btLogin);


        info.setText("No. of attempts remaining: 5");

        user_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(email.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("Admin")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        } else {
            counter--;

            info.setText("No. of attempts remaining: " + String.valueOf(counter));

            if (counter == 0) {
                login.setEnabled(false);
            }
        }

    }
}
