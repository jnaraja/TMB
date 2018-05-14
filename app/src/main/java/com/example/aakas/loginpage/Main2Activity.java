package com.example.aakas.loginpage;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private TextView mTextMessage;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<RecyclerItem> listItem;
    private ViewPager viewPager;
    private static final String TAG = "Main2Activity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_maps:
                    //mTextMessage.setText(R.string.title_home);
                    if(isServicesOK()) {
                        Intent intent = new Intent(Main2Activity.this, MapsActivity.class);
                        startActivity(intent);
                        return true;
                    }
                case R.id.navigation_trails:
                    Intent toy = new Intent(Main2Activity.this,Main2Activity.class);
                    startActivity(toy);
                    return true;
                case R.id.navigation_account:
                    Intent toy2 = new Intent(Main2Activity.this,account2.class);
                    startActivity(toy2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //viewPager.setCurrentItem(2);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_trails);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        //mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItem = new ArrayList<>();
        // sample data

        for (int i = 0; i<10; i++){
            listItem.add(new RecyclerItem("Trail #" + (i+1), "Location #" +(i+1) ));
        }

        // set adapter
        mAdapter = new MyAdapter(listItem, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Main2Activity.this);

        if(available == ConnectionResult.SUCCESS){
            // Successful, user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");

            return true;
        }

        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //error occurred, but can be resolved
            Log.d(TAG, "isServicesOK: Error occurred, but can be resolved");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(Main2Activity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}
