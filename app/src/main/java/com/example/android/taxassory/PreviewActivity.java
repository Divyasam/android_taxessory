package com.example.android.taxassory;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class PreviewActivity extends AppCompatActivity {


    private static final int CAMERA_PIC_REQUEST = 1337;
    private TextView textViewFilename;
    private TextView textViewDesc;
    private Button okButton;
    ImageView touchImage = (ImageView)findViewById(R.id.touchImage);

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);



       Button upload_btn = (Button) findViewById(R.id.upload_btn);

       Intent intent_camera = getIntent();

       Bitmap camera_img_bitmap = (Bitmap) intent_camera.getParcelableExtra("BitmapImage");


        if (camera_img_bitmap != null)
        {
            touchImage.setImageBitmap(camera_img_bitmap);

        }




        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             openDialog();
            }
        });







        Intent i = new Intent(this, DialogBox.class);
        i.putExtra("MY_FILE", camera_img_bitmap);
    }


    public void openDialog()
    {
        DialogBox dialogBox = new DialogBox();
        dialogBox.show(getSupportFragmentManager(), "Dialog Box");


    }



//    public void applyTexts(String name, String desc) {
//
//    }
}