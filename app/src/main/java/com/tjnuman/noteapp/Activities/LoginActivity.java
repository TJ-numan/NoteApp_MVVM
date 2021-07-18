package com.tjnuman.noteapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tjnuman.noteapp.Retrofit.JsonPlaceholderAPI;
import com.tjnuman.noteapp.Retrofit.LoginModel;
import com.tjnuman.noteapp.Database.SessionManager;
import com.tjnuman.noteapp.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding bindingLogin;
    String userName, password;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingLogin = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(bindingLogin.getRoot());


         session = new SessionManager(this);



        bindingLogin.loginBtn.setOnClickListener(v -> {
            checkcrendentials();


//            Intent intent2 = new Intent(LoginActivity.this,DashboardActivity.class);
//            startActivity(intent2);


        });
    }

    private void checkcrendentials() {
        userName = bindingLogin.fullname.getText().toString();
        password = bindingLogin.password.getText().toString();

        if(userName.isEmpty())
        {
            bindingLogin.fullname.setError("User Name is required");
            bindingLogin.fullname.requestFocus();
            return;
        }

        else if(password.isEmpty())
        {
            bindingLogin.password.setError("Password can't be empty");
            bindingLogin.password.requestFocus();
            return;
        }
        else if(password.length()<6)
        {
            bindingLogin.password.setError("Password length should be 6 charectars!");
            bindingLogin.password.requestFocus();
            return;
        }

        else {
            session.setLoginStatus(true);
            Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
            startActivity(intent);
            login();
        }

    }

    private void login() {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonPlaceholderAPI.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholderAPI jsonPlaceholderAPI = retrofit.create(JsonPlaceholderAPI.class);
        LoginModel loginModel = new LoginModel();
        loginModel.setUserName(userName);
        loginModel.setPassword(password);
        Call<LoginModel> call = jsonPlaceholderAPI.loginUser(loginModel);


        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                Log.d("responce",response.toString());
                if(!response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                }else {

                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}