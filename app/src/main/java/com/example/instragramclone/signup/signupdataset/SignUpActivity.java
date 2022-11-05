package com.example.instragramclone.signup.signupdataset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instragramclone.R;
import com.example.instragramclone.login.LoginActivity;

public class SignUpActivity extends AppCompatActivity {

    EditText getEmailEditText;
    Button nextButton;
    TextView gotoLoginActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getEmailEditText = findViewById(R.id.getEmailEditText);
        nextButton = findViewById(R.id.nextButton);
        gotoLoginActivity = findViewById(R.id.gotoLoginActivity);

        getEmailEditText.setCursorVisible(false);

        getEmailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nextButton.setEnabled(true);
                nextButton.setAlpha(1f);
                getEmailEditText.setCursorVisible(true);
                getEmailEditText.setSelection(getEmailEditText.getText().length());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SignupDataSetActivity.class);
                intent.putExtra("useremail", getEmailEditText.getText().toString());
                startActivity(intent);
            }
        });


        gotoLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });



    }
}