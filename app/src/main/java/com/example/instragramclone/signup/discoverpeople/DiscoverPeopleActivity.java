package com.example.instragramclone.signup.discoverpeople;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.instragramclone.R;
import com.example.instragramclone.home.HomePageActiviy;
import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DiscoverPeopleActivity extends AppCompatActivity {

    ArrayList<DiscoverPeopleModel> discoverPeopleList = new ArrayList<>();

    DiscoverPeopleAdapter discoverPeopleAdapter;
    RecyclerView followPeopleRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_people);

        ImageView forward = findViewById(R.id.forward);
        followPeopleRecyclerView = findViewById(R.id.followPeopleRecyclerView);

        followPeopleRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        discoverPeopleAdapter = new DiscoverPeopleAdapter(this, discoverPeopleList);
        followPeopleRecyclerView.setAdapter(discoverPeopleAdapter);



        ParseQuery<ParseObject> query = ParseQuery.getQuery("ProfilePicture");
        query.whereNotEqualTo("username", ParseUser.getCurrentUser().getUsername());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if (objects.size() > 0) {
                        Log.i("info", String.valueOf(objects.size()));

                        for (ParseObject image : objects) {

                            ParseFile file = (ParseFile) image.get("picture");

                            file.getDataInBackground(new GetDataCallback() {
                                @Override
                                public void done(byte[] data, ParseException e) {
                                    if (e == null) {
                                        if (data != null) {
                                            String[] splitName = (ParseUser.getCurrentUser().getUsername()).split(" ");
                                            discoverPeopleList.add(new DiscoverPeopleModel(data, R.drawable.cancel_image, splitName[0], ParseUser.getCurrentUser().getUsername()));
                                            discoverPeopleAdapter.notifyDataSetChanged();
                                        } else {
                                            Toast.makeText(DiscoverPeopleActivity.this, "no image in array", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(DiscoverPeopleActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                        }
                    } else {
                        Toast.makeText(DiscoverPeopleActivity.this, "no images found.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DiscoverPeopleActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiscoverPeopleActivity.this, HomePageActiviy.class);
                startActivity(intent);
            }
        });

    }
}