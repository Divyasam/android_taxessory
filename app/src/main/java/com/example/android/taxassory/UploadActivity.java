package com.example.android.taxassory;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.view.View;
import android.graphics.Bitmap;
import android.widget.EditText;
import android.widget.ImageView;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;


import com.example.android.taxassory.webservice.Retrofit2Client;
import com.example.android.taxassory.webservice.Retrofit2ClientImg;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;


public class UploadActivity extends AppCompatActivity {

    private static final int CAMERA_PIC_REQUEST = 1337;
    private static final String TAG = "UploadActivity";
    ImageView imageview;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private static boolean checkReadPermission = false;
    private static String imagePath = null;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        requestRead();

        Button camera = (Button) findViewById(R.id.cam_btn);
        Button upload_btn = (Button) findViewById(R.id.b_upload);
        imageview = (ImageView) findViewById(R.id.text3);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Uploading Image please wait..!");


        camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                        requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);

                    } else {

                        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                            startActivityForResult(takePictureIntent, CAMERA_PIC_REQUEST);
                        }

                    }


                } else {

                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, CAMERA_PIC_REQUEST);
                    }



                }
            }
        });

        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });


    }

    public void openDialog() {
        //DialogBox dialogBox = new DialogBox();
        //dialogBox.show(getSupportFragmentManager(), "Dialog Box");


        View view = LayoutInflater.from(this).inflate(R.layout.layout_dialog, null);
        AlertDialog.Builder alertBox = new AlertDialog.Builder(this);
        alertBox.setView(view);
        alertBox.setCancelable(false);
        final AlertDialog dialog = alertBox.create();

        final EditText editTextName = view.findViewById(R.id.edit_name);
        final EditText editTextDesc = view.findViewById(R.id.edit_desc);
        final TextView btnOk = view.findViewById(R.id.btn_dialog_ok);
        final TextView btnCancel = view.findViewById(R.id.btn_dialog_cancel);

        dialog.setTitle("Enter the details");

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextName.getText().toString().trim().isEmpty()) {
                    if (!editTextDesc.getText().toString().trim().isEmpty()) {
                        startUploading(editTextName.getText().toString(), editTextDesc.getText().toString());
                    } else {
                        editTextDesc.requestFocus();
                        editTextDesc.setError("This Field can't be empty");
                    }
                } else {
                    editTextName.requestFocus();
                    editTextName.setError("This Field can't be empty");
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void startUploading(String name, final String description) {
        final String userId = "5630742793027584";
        final String documentType = "W2";
        final String startYear = "2018";

//        data.append('description', description);
//        data.append('startYear', startYear);
//        data.append('document', file);
//        data.append('documentType', documentType);
//        data.append('userId', userId);

        /*if (imagePath != null) {
            dialog.show();
            File file = new File(imagePath);
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

            MultipartBody.Part body = MultipartBody.Part.createFormData("document", file.getName(), requestFile);

            RequestBody userIdBody = RequestBody.create(MediaType.parse("multipart/form-data"), userId);
            RequestBody documentTypeBody = RequestBody.create(MediaType.parse("multipart/form-data"), documentType);
            RequestBody yearBody = RequestBody.create(MediaType.parse("multipart/form-data"), year);
            RequestBody descBody = RequestBody.create(MediaType.parse("multipart/form-data"), desc);

            Retrofit2Client.getInstance().getFileUploadService().upload(userIdBody, body, descBody, documentTypeBody, yearBody).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    dialog.dismiss();
                    Toast.makeText(UploadActivity.this, "onResponse Success" + response.message(), Toast.LENGTH_SHORT).show();
                }
                // what was the error with this code? api is not being called
                // and the purpose is only to upload a file through an api right? yes it needs to get uploaded in the gcloud.
                // and you have a nodejs application there ?yes
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(UploadActivity.this, "onFailure " + t.getCause(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onFailure " + t.getCause());
                    Log.e(TAG, "onFailure " + t.getLocalizedMessage());
                    Log.e(TAG, "onFailure " + t.getMessage());
                    Log.e(TAG, "onFailure " + t.toString());
                    dialog.dismiss();
                }
            });
        }*/

        if (imagePath != null){
            dialog.show();
            final File FFile = new File(imagePath);
            RequestBody requestFile = (RequestBody) RequestBody.create(MediaType.parse("multipart/form-data"),FFile);
            final MultipartBody.Part file = (MultipartBody.Part) MultipartBody.Part.createFormData("document",FFile.getName(), requestFile);
            //Toast.makeText(getApplicationContext(),document.toString(), Toast.LENGTH_LONG).show();
           /* Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try  {   OkHttpClient client = new OkHttpClient();


                        final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

                        RequestBody requestBody = new MultipartBuilder()
                                .type(MultipartBuilder.FORM)
                                .addFormDataPart("document", FFile.getName(), RequestBody.create(MEDIA_TYPE_PNG, FFile))

                                .addFormDataPart("userId", userId)//this is what I say in my POSTman (Chrome plugin)


                                .addFormDataPart("desciption", description)
                                .addFormDataPart("docuemntType", documentType)
                                .addFormDataPart("startYear", startYear)
                                .build();
                        Request request = new Request.Builder()
                                .url("http://10.0.0.13:8080/api/documents/upload")
                                .post(requestBody)
                                .build();
                        Response response = client.newCall(request).execute();
                        String responseString = response.body().string();
                        // response.body().close();
                        // Toast.makeText(getApplicationContext(), responseString,Toast.LENGTH_LONG).show();
                        //Your code goes here
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });






            thread.start();*/

         // Retrofit2ClientImg.getInstance().getFileUploadService().postImage(userId,file,description,documentType,startYear).enqueue(new Callback<ResponseBody>() {
           Retrofit2ClientImg.getInstance().getFileUploadService().postImage(userId,file,description,documentType,startYear).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    dialog.dismiss();
                    Log.e(TAG,"onSuccess response.body() "+response.body().toString());
                    Log.e(TAG,"onSuccess response.toString() "+response.toString());
                    Log.e(TAG,"onSuccess response.message() "+response.message());
                    Log.e(TAG,"onSuccess response.code() "+response.code());
                    Log.e(TAG,"onSuccess response.errorBody() "+response.errorBody());
                    Log.e(TAG,"onSuccess response.raw() "+response.raw());
                    Toast.makeText(UploadActivity.this, "onResponse Success" + response.message(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(UploadActivity.this, "onFailure " + t.getCause(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onFailure " + t.getCause());
                    Log.e(TAG, "onFailure " + t.getLocalizedMessage());
                    Log.e(TAG, "onFailure " + t.getMessage());
                    Log.e(TAG, "onFailure " + t.toString());
                    dialog.dismiss();
                }
            });
        }}


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST && resultCode == RESULT_OK) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            Intent IntentCamera = new Intent(this, PreviewActivity.class);
            IntentCamera.putExtra("BitmapImage", image);
            //startActivity(IntentCamera);
            imageview.setImageBitmap(image);

            // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
            if (checkReadPermission) {
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String imageFileName = "JPEG_" + timeStamp + "_";
                File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                try {
                    File image1 = File.createTempFile(
                            imageFileName,  /* prefix */
                            ".jpg",         /* suffix */
                            storageDir      /* directory */
                    );

                    imagePath = image1.getAbsolutePath();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                /*Uri tempUri = getImageUri(getApplicationContext(), image);
                imagePath = getRealPathFromURI(tempUri);
                Toast.makeText(this, "Image Path " + getRealPathFromURI(tempUri), Toast.LENGTH_SHORT).show();*/
            }
            /*sending image to dialog class*/
            //Intent i = new Intent(this, DialogBox.class);
            //i.putExtra("MY_FILE", image);
        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);



    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    public void requestRead() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
        } else {
            checkReadPermission = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                checkReadPermission = true;
            } else {
                // Permission Denied
                Toast.makeText(UploadActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}