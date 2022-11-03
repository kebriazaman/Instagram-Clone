package com.example.instragramclone.login.myaccounts;

import android.app.Dialog;

public class MyAccountsModel {

    int myImage, remove_from_list;
    String username;

    public MyAccountsModel(int myImage, String username, int remove_from_list) {
        this.myImage = myImage;
        this.username = username;
        this.remove_from_list = remove_from_list;
    }
}
