package com.example.foodfactory.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.foodfactory.R;

public class LocationSpecification extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LocationSpecification";

    private Button currentLocationButton, anotherLocationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_specification);
        //Initializing wiz
        intintwiz();
        currentLocationButton.setOnClickListener(this);
    }

    private void intintwiz() {
        Log.d(TAG, "intintwiz calling");
        currentLocationButton = findViewById(R.id.use_current_location_bt);
        anotherLocationButton = findViewById(R.id.use_anther_location_bt);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.use_current_location_bt) {
            Log.d(TAG, "onClick: currentLocationButton is clicked");
            Intent intent = new Intent(LocationSpecification.this, HomeActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.use_anther_location_bt){
            Log.d(TAG, "onClick: anotherLocationButton is clicked");
        }


    }
}
