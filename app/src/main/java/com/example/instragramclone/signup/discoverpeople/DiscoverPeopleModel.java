package com.example.instragramclone.signup.discoverpeople;

import android.graphics.Bitmap;

public class DiscoverPeopleModel {

    byte[] data;
    int remove;
    String name, fullName;

    public DiscoverPeopleModel(byte[] data, int remove, String name, String fullName) {

        this.data = data;
        this.remove = remove;
        this.name = name;
        this.fullName = fullName;

    }

}
