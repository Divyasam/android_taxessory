package com.example.android.taxassory;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.taxassory.webservice.JSON_Parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText pass;
    Button login;
    TextView reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        reset = findViewById(R.id.reset);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass.getText().toString().equals(""))
                { pass.setError("Enter the password");}
                if(email.getText().toString().equals("")|| !Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
                { email.setError("Enter a valid email");}
                else
                    {

                        Log.d("response", email.getText().toString());
                        new Login_Async( getApplicationContext(), email.getText().toString(),pass.getText().toString()).execute();

                    }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetIntent = new Intent(LoginActivity.this, UploadActivity.class);
                startActivity(resetIntent);
            }
        });

        pass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(email.getText().toString().equals("")|| !Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
                    email.setError("Enter a valid email");
                return false;
            }
        });

    }
    public class Login_Async extends AsyncTask<Void, Double, String> {

       // Context context;
        //Runnable onComplete;
        //String authendication;
        boolean isLoaded = false;
        String username , password;



        public Login_Async(Context context , String username , String password)
        {
           // this.context = context;
            //this.onComplete = onComplete;
           // this.authendication = authentications;
            this.username = username;
            this.password = password;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected String doInBackground(Void... arg0) {
            try {

                JSON_Parser json_parser = new JSON_Parser();

                String data = "{\"email\":\""+username+"\",\"password\":\""+password+"\"}";
               // Log.d("response", job.toString());
                JSONObject job = json_parser.makeHTTPPOST("http://10.0.0.13:8080/api/login","POST" , data,"");

                Log.d("response", job.toString());
                return job.toString();
                // }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            //super.onPostExecute(result);

            boolean status=parseJSON(result);

            if(status) {
                Intent loginIntent = new Intent(LoginActivity.this, FingerPrintActivity.class);
                startActivity(loginIntent);
            }else{
                Toast.makeText(LoginActivity.this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
            }
        }

    }



    public boolean parseJSON(String result){

        boolean flag=false;

        try {
            JSONObject parent=new JSONObject(result);

            String status=parent.optString("status");
            if(status.equals("success"))
                flag=true;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return flag;
    }


}
