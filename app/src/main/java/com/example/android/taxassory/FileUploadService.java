package com.example.android.taxassory;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Multipart;
import retrofit2.http.Part;
import retrofit2.Call;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;
import retrofit2.http.Query;

public interface FileUploadService {

    @Multipart
    @POST("upload")
    Call<ResponseBody> upload(@Part("userId") RequestBody  userId, @Part MultipartBody.Part file, @Part("description") RequestBody  description, @Part("documentType") RequestBody  documentType, @Part("startYear") RequestBody  startYear);

    /*@Headers({
            "Authorization: Client-ID 0b5e46b0ac7b39f"
    })*/

    @Multipart
    @POST("image")
    Call<ResponseBody> postImage(
            @Query("userId") String userId,
            @Part MultipartBody.Part file,
            @Query("description") String description,
            @Query("documentType") String documentType,
            @Query("startYear") String startYear);

}
