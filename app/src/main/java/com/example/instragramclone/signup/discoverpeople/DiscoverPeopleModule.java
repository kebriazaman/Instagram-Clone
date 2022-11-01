package com.example.instragramclone.signup.discoverpeople;

import android.net.Uri;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DiscoverPeopleModule {

    int image, remove;
    String name, fullName;

    public DiscoverPeopleModule(int image, int remove, String name, String fullName) {

        this.image = image;
        this.remove = remove;
        this.name = name;
        this.fullName = fullName;

    }
}
