package com.example.instragramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("s7UIbCdKj7yILEuim1srxLnhpZJ9spy8zjT79FI9")
                .clientKey("mCD98X8hpDWxWeuxquvOuV70DnQdYPDevhaPO76a")
                .server("https://parseapi.back4app.com/")
                .build());
    }
}
