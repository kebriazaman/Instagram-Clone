package com.example.instragramclone.signup.signupdataset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

        fullName.addTextChangedListener(new TextWatcher() { @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }@Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if ( editable.length() >= 4 ) {

                    fullName.setSelection(fullName.getText().length());

                    userPassword.addTextChangedListener(new TextWatcher() {@Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }@Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                            if (editable.length() >= 4) {
                                continueButton.setEnabled(true);
                                continueButton.setAlpha(1f);
                                userPassword.setSelection(userPassword.getText().length());
                            } else {
                                continueButton.setEnabled(false);
                                continueButton.setAlpha(0.4f);
                            }


                        }
                    });
                } else {
                    continueButton.setEnabled(false);
                    continueButton.setAlpha(0.4f);
                }
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getEmailIntent = getIntent();
                Intent intent = new Intent(SignupDataSetActivity.this, SignupConfirmActivity.class);
                intent.putExtra("fullname", fullName.getText().toString());
                intent.putExtra("userpassword", userPassword.getText().toString());
                intent.putExtra("email", getEmailIntent.getStringExtra("useremail"));
                startActivity(intent);
            }
        });

    }
}