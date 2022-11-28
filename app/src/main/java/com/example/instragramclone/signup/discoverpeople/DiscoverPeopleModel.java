package com.example.instragramclone.signup.discoverpeople;

import android.graphics.Bitmap;
import android.util.Log;

public class DiscoverPeopleModel {

    Bitmap bitmap;
    int remove;
    String name, fullName;

    public DiscoverPeopleModel(Bitmap bitmap, String name, String fullName, int remove) {

        this.bitmap = bitmap;
        this.remove = remove;
        this.name = name;
        this.fullName = fullName;

    }
}
