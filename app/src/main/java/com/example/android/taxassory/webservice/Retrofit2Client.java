package com.example.android.taxassory.webservice;

import com.example.android.taxassory.FileUploadService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2Client {

    private static Retrofit2Client instance = null;
    private FileUploadService fileUploadService;

    private Retrofit2Client(){

        OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.0.13:8080/api/documents/upload") //  https://10.0.0.3:8080/api/documents/
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        fileUploadService = retrofit.create(FileUploadService.class);
    }

    public static Retrofit2Client getInstance() {
        if (instance == null) {
            instance = new Retrofit2Client();
        }

        return instance;
    }

    public FileUploadService getFileUploadService() {
        return fileUploadService;
    }
}
