package com.example.instragramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.instragramclone.login.myaccounts.MyAccountsActivity;
import com.example.instragramclone.signup.ChangeUserNameActivity;
import com.example.instragramclone.signup.signupdataset.SignUpActivity;

public class IntroScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);


        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.splash_notifi_bar_color));
        }

        Thread thread = new Thread(){
            public void run(){
                try{
                    // screen will be hold for 2 secs
                    sleep(2000);
                }
                catch (Exception ex){
                    // msg will be printed if exception is caught
                    ex.printStackTrace();
                }
                finally{
                    // Code for going from splash screen to main activity
                    Intent intent = new Intent(IntroScreenActivity.this, SignUpActivity.class);
                    startActivity(intent);
                    finishAffinity();
                }
            }
            // starting the thread
        };thread.start();
    }
}