package com.example.android.taxassory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.widget.Button;
import android.view.View;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.widget.TextView;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.app.Activity;


public class UploadActivity extends AppCompatActivity {

    UploadActivity imagePro;
    Activity activity;
    private static final int CAMERA_PIC_REQUEST = 1337;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);


        Button camera = (Button) findViewById(R.id.cam_btn);


        camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);

                startActivityForResult(intent, CAMERA_PIC_REQUEST);

            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            Bitmap image = (Bitmap)data.getExtras().get("data");
            ImageView imageview = (ImageView) findViewById(R.id.text3); //sets imageview as the bitmap
            imageview.setImageBitmap(image);
        }
    }







}