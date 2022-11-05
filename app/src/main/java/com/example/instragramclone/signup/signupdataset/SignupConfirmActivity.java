package com.example.instragramclone.signup.signupdataset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.instragramclone.R;
import com.example.instragramclone.signup.AddPhotoActivity;
import com.example.instragramclone.signup.ChangeUserNameActivity;

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

                Intent intent = new Intent(SignupConfirmActivity.this, AddPhotoActivity.class);
                intent.putExtra("fullname", getDataSet.getStringExtra("fullname"));
                intent.putExtra("userpassword", getDataSet.getStringExtra("userpassword"));
                intent.putExtra("email", getDataSet.getStringExtra("email"));
                startActivity(intent);
                /*ParseUser user = new ParseUser();
                user.setUsername(getDataSet.getStringExtra("fullname"));
                user.setPassword(getDataSet.getStringExtra("userpassword"));
                user.setEmail(getDataSet.getStringExtra("email"));
                user.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if ( e == null ) {

                        }
                    }
                });*/
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