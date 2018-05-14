package com.example.aakas.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class delete extends AppCompatActivity {

    public Button but1;
    public Button but2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        init();

    }

    public void init()
    {
        but1 = (Button) findViewById(R.id.yesbutton);
        but2 = (Button) findViewById(R.id.nobutton);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hello here");
                System.out.println();
                Intent toy = new Intent(delete.this,displayTrails.class);
                startActivity(toy);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy2 = new Intent(delete.this,Trail_info.class);
                startActivity(toy2);
            }
        });
    }
}
