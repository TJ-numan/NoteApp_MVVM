package com.tjnuman.noteapp.Retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceholderAPI {


    @POST("posts")
    Call<LoginModel>loginUser(@Body LoginModel login);
}
