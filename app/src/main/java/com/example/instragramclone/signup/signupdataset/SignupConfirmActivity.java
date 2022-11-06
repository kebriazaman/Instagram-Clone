package com.example.instragramclone.signup.signupdataset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instragramclone.R;
import com.example.instragramclone.signup.AddPhotoActivity;
import com.example.instragramclone.signup.ChangeUserNameActivity;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class SignupConfirmActivity extends AppCompatActivity {

    TextView name;
    Intent getDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_confirm);

        Button signupButton = findViewById(R.id.signupButton);
        TextView chageUserNameTextView = findViewById(R.id.changeUserName);


        getDataSet = getIntent();

        name = findViewById(R.id.name);

        String[] splitUserName = (getDataSet.getStringExtra("email")).split("@");

        name.setText(splitUserName[0]+"?");

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser user = new ParseUser();
                user.setEmail(getDataSet.getStringExtra("email"));
                user.setUsername(getDataSet.getStringExtra("fullname"));
                user.setPassword(getDataSet.getStringExtra("userpassword"));
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if ( e == null ) {
                            Toast.makeText(SignupConfirmActivity.this, ParseUser.getCurrentUser().getUsername()+"singed up.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignupConfirmActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Intent intent = new Intent(SignupConfirmActivity.this, AddPhotoActivity.class);
                startActivity(intent);
            }
        });

        chageUserNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupConfirmActivity.this, ChangeUserNameActivity.class);
                intent.putExtra("username", splitUserName[0]);
                startActivity(intent);
            }
        });

    }
}