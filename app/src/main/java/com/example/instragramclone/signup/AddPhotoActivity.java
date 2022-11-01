package com.example.instragramclone.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.instragramclone.R;
import com.example.instragramclone.signup.discoverpeople.DiscoverPeopleActivity;

public class AddPhotoActivity extends AppCompatActivity {

    TextView skipToAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        skipToAdd = findViewById(R.id.skipToAdd);

        skipToAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddPhotoActivity.this, DiscoverPeopleActivity.class);
                // pass image as well by intent right here
                intent.putExtra("fullname", getIntent().getStringExtra("fullname"));
                intent.putExtra("userpassword", getIntent().getStringExtra("userpassword"));
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });



    }
}