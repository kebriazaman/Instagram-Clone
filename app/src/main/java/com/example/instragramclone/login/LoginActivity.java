package com.example.instragramclone.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.instragramclone.R;
import com.example.instragramclone.signup.SignUpActivity;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    Button loginButton;
    TextView getHelpTextView, gotoLoginActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emaiEditText);
        passwordEditText = findViewById(R.id.emaiEditText);
        getHelpTextView = findViewById(R.id.getHelpTextView);

        gotoLoginActivity = findViewById(R.id.gotoLoginActivity);

        gotoLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}