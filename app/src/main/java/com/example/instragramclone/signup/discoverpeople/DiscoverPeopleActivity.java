package com.example.instragramclone.signup.discoverpeople;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.instragramclone.R;

import java.util.ArrayList;

public class DiscoverPeopleActivity extends AppCompatActivity {

    ArrayList<DiscoverPeopleModel> discoverPeopleList;
    DiscoverPeopleAdapter discoverPeopleAdapter;
    RecyclerView followPeopleRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_people);

        ImageView forward = findViewById(R.id.forward);
        followPeopleRecyclerView = findViewById(R.id.followPeopleRecyclerView);

        discoverPeopleList = new ArrayList<>();
        discoverPeopleList.add(new DiscoverPeopleModel(R.drawable.elon_musk, R.drawable.cancel_image, "Elon", "Elon Musk"));
        discoverPeopleList.add(new DiscoverPeopleModel(R.drawable.faizi, R.drawable.cancel_image, "Faizi", "Faizan Musk"));
        followPeopleRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        discoverPeopleAdapter = new DiscoverPeopleAdapter(this, discoverPeopleList);
        followPeopleRecyclerView.setAdapter(discoverPeopleAdapter);


        /*forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiscoverPeopleActivity.this, HomePageActiviy.class);
                intent.putExtra("fullname", getIntent().getStringExtra("fullname"));
                intent.putExtra("userpassword", getIntent().getStringExtra("userpassword"));
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });*/

    }
}