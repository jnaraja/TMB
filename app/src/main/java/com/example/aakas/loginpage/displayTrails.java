package com.example.aakas.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class displayTrails extends AppCompatActivity {

    public Button but1;

    public void init() {
        but1 = (Button) findViewById(R.id.TrailButton);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(displayTrails.this, Trail_info.class);
                //getIntent().putExtra("time",25);
                startActivity(toy);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trails);
        init();
    }
}
