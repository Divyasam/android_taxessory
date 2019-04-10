package com.example.android.taxassory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PinActivity extends AppCompatActivity {

    TextView pin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        pin = findViewById(R.id.pin);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
    }
}
