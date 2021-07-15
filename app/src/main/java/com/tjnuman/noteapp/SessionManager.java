package com.tjnuman.noteapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private final String LOGIN_STATUS = "login_status";
    private final SharedPreferences prefs;
    public SharedPreferences.Editor editor;


    public SessionManager(Context context) {
        String SHAREDPREFERENCE_NAME = "USER_SESSION";
        prefs = context.getSharedPreferences(SHAREDPREFERENCE_NAME,Context.MODE_PRIVATE);
    }

    public void setLoginStatus(boolean status){
        editor = prefs.edit();
        editor.putBoolean(LOGIN_STATUS,status);
        editor.apply();
    }

    public boolean getLoginStatus(){
        return prefs.getBoolean(LOGIN_STATUS,false);
    }
}
