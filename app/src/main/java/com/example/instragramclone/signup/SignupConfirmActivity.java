package com.example.instragramclone.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.instragramclone.R;

public class SignupConfirmActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_confirm);

        Button signupButton = findViewById(R.id.signupButton);
        TextView chageUserNameTextView = findViewById(R.id.changeUserName);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupConfirmActivity.this, ChangeUserNameActivity.class);
                startActivity(intent);
            }
        });

    }
}