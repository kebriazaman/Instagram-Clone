package com.example.instragramclone.signup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.instragramclone.R;
import com.example.instragramclone.home.HomePageActiviy;

public class DiscoverPeopleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_people);

        ImageView forward = findViewById(R.id.forward);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiscoverPeopleActivity.this, HomePageActiviy.class);
                intent.putExtra("fullname", getIntent().getStringExtra("fullname"));
                intent.putExtra("userpassword", getIntent().getStringExtra("userpassword"));
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });

    }
}