package com.tjnuman.noteapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.tjnuman.noteapp.R;
import com.tjnuman.noteapp.Retrofit.JsonPlaceholderAPI;
import com.tjnuman.noteapp.Retrofit.LoginModel;
import com.tjnuman.noteapp.databinding.ActivityInitialBinding;
import com.tjnuman.noteapp.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding bindingLogin;
    String userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingLogin = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(bindingLogin.getRoot());

         userName = bindingLogin.fullname.getText().toString();
         password = bindingLogin.password.getText().toString();



        bindingLogin.loginBtn.setOnClickListener(v -> {
           // login();
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(LoginActivity.this,DashboardActivity.class);
            startActivity(intent2);


        });
    }

    private void login() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.129.13.191:8082/demo")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholderAPI jsonPlaceholderAPI = retrofit.create(JsonPlaceholderAPI.class);
        LoginModel loginModel = new LoginModel();
        loginModel.setUserName(userName);
        loginModel.setUserName(password);
        Call<LoginModel> call = jsonPlaceholderAPI.loginUser(loginModel);


        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}