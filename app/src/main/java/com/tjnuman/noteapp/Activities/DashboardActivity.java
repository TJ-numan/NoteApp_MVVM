package com.tjnuman.noteapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tjnuman.noteapp.Fragments.CalenderFragment;
import com.tjnuman.noteapp.Fragments.FavoriteFragment;
import com.tjnuman.noteapp.Fragments.NotesFragment;
import com.tjnuman.noteapp.Fragments.SettingFragment;
import com.tjnuman.noteapp.R;
import com.tjnuman.noteapp.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity { //run den vai dekhi
    ActivityDashboardBinding dashboardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(dashboardBinding.getRoot());

        dashboardBinding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId())
                {
                    case R.id.calender:
                        selectedFragment = new CalenderFragment();
                        break;

                    case R.id.note:
                        selectedFragment = new NotesFragment();
                        break;

                    case R.id.fvrt:
                        selectedFragment = new FavoriteFragment();
                        break;

                    case R.id.settings:
                        selectedFragment = new SettingFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
                return false;
            }
        });
    }
}