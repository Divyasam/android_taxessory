package com.example.android.taxassory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResetActivity extends AppCompatActivity {


    EditText newpass;
    EditText confirmpass;
    Button reset;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        newpass = findViewById(R.id.newpass);
        confirmpass = findViewById(R.id.confirmpass);
        reset = findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newpass.getText().toString().equals(""))
                { newpass.setError("Enter the password");}
                if(confirmpass.getText().toString().equals(""))
                { confirmpass.setError("Enter the password");}
                else{
                    Intent loginIntent = new Intent(ResetActivity.this, MainActivity.class);
                    startActivity(loginIntent);
                }
            }
        });
    }
}
