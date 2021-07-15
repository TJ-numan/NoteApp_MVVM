package com.tjnuman.noteapp.Retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JsonPlaceholderAPI {


        String URL_BASE = "http://3.129.13.191:8082/demo/";

        @Headers("Content-Type: application/json")
        @POST("login")
        Call<LoginModel> loginUser(@Body LoginModel login);

}
