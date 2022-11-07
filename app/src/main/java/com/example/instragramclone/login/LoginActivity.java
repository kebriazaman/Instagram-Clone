package com.example.instragramclone.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instragramclone.R;
import com.example.instragramclone.home.HomePageActiviy;
import com.example.instragramclone.signup.signupdataset.SignUpActivity;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    Button loginButton;
    TextView getHelpTextView, gotoLoginActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emaiEditText);
        passwordEditText = findViewById(R.id.passwrodEditText);
        getHelpTextView = findViewById(R.id.getHelpTextView);
        loginButton = findViewById(R.id.loginButton);
        gotoLoginActivity = findViewById(R.id.gotoLoginActivity);


        emailEditText.setSelection(emailEditText.getText().length());
        passwordEditText.setSelection(passwordEditText.getText().length());

        gotoLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseUser.logInInBackground(emailEditText.getText().toString(),
                        passwordEditText.getText().toString(), new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if ( user != null && e == null ) {
                                    Intent intent = new Intent(LoginActivity.this, HomePageActiviy.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this, "Could not be logged in "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}