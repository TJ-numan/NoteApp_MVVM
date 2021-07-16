package com.tjnuman.noteapp.Retrofit;

public class LoginModel {
 private String UserName;
 private String Password;

    public LoginModel(String userName, String password) {
        this.UserName = userName;
        this.Password = password;
    }

    public LoginModel() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }


}
