package com.tjnuman.noteapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tjnuman.noteapp.Database.SessionManager;
import com.tjnuman.noteapp.databinding.ActivityInitialBinding;

public class InitialActivity extends AppCompatActivity {

    ActivityInitialBinding bindingInitial;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingInitial = ActivityInitialBinding.inflate(getLayoutInflater());
        setContentView(bindingInitial.getRoot());
        sessionManager  = new SessionManager(this);


        bindingInitial.getStartedBtn.setOnClickListener(v -> {
            Intent intent;
            if (sessionManager.getLoginStatus()){
                intent = new Intent(InitialActivity.this, DashboardActivity.class);
            }else {
                intent = new Intent(InitialActivity.this, LoginActivity.class);
            }
            startActivity(intent);

        });
    }
}