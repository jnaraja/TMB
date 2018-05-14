package com.example.aakas.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Trail_info extends AppCompatActivity {

    private TextView mTextMessage;

    public Button but1;
    public Button but3;
    public Button but2;
    public TextView displayTime;

    public void init()
    {
        System.out.println("Here");
        displayTime = (TextView)findViewById(R.id.displayTime);
        long startTime = System.currentTimeMillis();
        long x;
        for(int i = 0; i < 10000; i ++)
            x= 0;
        long endTime = System.currentTimeMillis();
        int totalMin = (int)((endTime - startTime)/(60000));
        int hours = (int)(totalMin/60);
        int displayMin = totalMin%60;
        displayTime.setText(hours +":" + displayMin);


        but1 = (Button) findViewById(R.id.delete_trail);
        but2 = (Button) findViewById(R.id.share_trail);
        but3 = (Button) findViewById(R.id.images);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(Trail_info.this, delete.class);
                startActivity(toy);

            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(Trail_info.this, share_trail.class);
                //getIntent().putExtra("time",25);
                startActivity(toy);
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(Trail_info.this, images_page.class);
                startActivity(toy);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_info);
        init();
    }
}
