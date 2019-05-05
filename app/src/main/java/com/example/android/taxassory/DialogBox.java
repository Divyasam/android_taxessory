package com.example.android.taxassory;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.graphics.Bitmap;
import android.widget.Toast;
import org.apache.http.client.methods.HttpPost;

import com.example.android.taxassory.webservice.JSON_Parser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;


public class DialogBox extends AppCompatDialogFragment {

    private EditText editTextName;
    private EditText editTextDesc;


    Intent intent = new Intent();
    File myFile = (File) intent.getSerializableExtra("MY_FILE");
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Enter the details")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Upload_file();
                        }

                });




        editTextName = view.findViewById(R.id.edit_name);
        editTextDesc = view.findViewById(R.id.edit_desc);
        return builder.create();
    }

    private void Upload_file() {
        try {

            //RequestBody desc = RequestBody.create(MultipartBody.FORM, editTextName.getText().toString());

            String userId = "22";
            String documentType = "w2";
            String year = "2017";








             }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onPostExecute(String result) {
        //super.onPostExecute(result);

        boolean status=parseJSON(result);

        if(status) {

        }else{

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






