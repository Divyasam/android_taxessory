package com.example.android.taxassory;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.widget.Button;
import android.view.View;
import android.graphics.Bitmap;
import android.widget.ImageView;
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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                            requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);

                    }
                    else{

                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                        startActivityForResult(intent, CAMERA_PIC_REQUEST);

                    }


                } else{

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivityForResult(intent, CAMERA_PIC_REQUEST);

                }
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            Bitmap image = (Bitmap)data.getExtras().get("data");
            ImageView imageview = (ImageView) findViewById(R.id.text3);
            imageview.setImageBitmap(image);
        }
    }







}