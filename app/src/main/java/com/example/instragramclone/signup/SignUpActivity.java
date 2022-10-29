package com.example.instragramclone.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.instragramclone.R;
import com.parse.ParseUser;

public class SignUpActivity extends AppCompatActivity {

    EditText getEmailEditText;
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getEmailEditText = findViewById(R.id.getEmailEditText);
        nextButton = findViewById(R.id.nextButton);




        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String myEmail, myUsername;

                /*myEmail = String.valueOf(getEmailEditText.getText());
                *//*String[] splitEmail = myEmail.split("@");
                myUsername = splitEmail[0];*/

                /*ParseUser user = new ParseUser();
                user.setEmail(getEmailEditText.getText().toString());
                user.saveInBackground();*/

                Intent intent = new Intent(SignUpActivity.this, SignupDataSetActivity.class);
                intent.putExtra("useremail", getEmailEditText.getText().toString());
                startActivity(intent);
            }
        });

    }
}