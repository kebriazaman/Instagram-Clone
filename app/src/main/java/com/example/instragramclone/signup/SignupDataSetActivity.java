package com.example.instragramclone.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.instragramclone.R;

public class SignupDataSetActivity extends AppCompatActivity {

    EditText fullName, userPassword;
    Button continueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_data_set);

        fullName = findViewById(R.id.fullName);
        userPassword = findViewById(R.id.userPassword);

        continueButton = findViewById(R.id.continueButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupDataSetActivity.this, SignupConfirmActivity.class);
                startActivity(intent);
            }
        });

    }
}