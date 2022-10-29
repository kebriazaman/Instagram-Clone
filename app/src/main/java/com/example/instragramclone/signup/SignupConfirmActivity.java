package com.example.instragramclone.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.instragramclone.R;

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
            }
        });

    }
}