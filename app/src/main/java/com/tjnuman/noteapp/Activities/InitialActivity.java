package com.tjnuman.noteapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tjnuman.noteapp.databinding.ActivityInitialBinding;

public class InitialActivity extends AppCompatActivity {

    ActivityInitialBinding bindingInitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingInitial = ActivityInitialBinding.inflate(getLayoutInflater());
        setContentView(bindingInitial.getRoot());


        bindingInitial.getStartedBtn.setOnClickListener(v -> {
            Intent intent = new Intent(InitialActivity.this, LoginActivity.class);
            startActivity(intent);
        });





    }
}