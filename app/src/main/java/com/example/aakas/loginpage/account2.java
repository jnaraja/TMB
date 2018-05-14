package com.example.aakas.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class account2 extends AppCompatActivity {

    private EditText newPass;
    private Button but1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account2);
        init();
    }

    public void init()
    {
        but1 = (Button) findViewById(R.id.button2);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(account2.this, Main2Activity.class);
                startActivity(toy);
            }
        });

    }
}
