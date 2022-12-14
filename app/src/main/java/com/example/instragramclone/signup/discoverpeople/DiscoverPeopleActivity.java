package com.example.instragramclone.signup.discoverpeople;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.instragramclone.R;
import com.example.instragramclone.home.HomePageActiviy;
import com.example.instragramclone.signup.AddPhotoActivity;
import com.example.instragramclone.signup.signupdataset.BitmapDataTransfer;
import com.example.instragramclone.signup.signupdataset.SignupConfirmActivity;
import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DiscoverPeopleActivity extends AppCompatActivity {

    ArrayList<DiscoverPeopleModel> discoverPeopleList = new ArrayList<>();

    DiscoverPeopleAdapter discoverPeopleAdapter;
    RecyclerView followPeopleRecyclerView;
    Button followButton;

    ArrayList<Bitmap> setBitmapList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_people);

        ImageView forward = findViewById(R.id.forward);
        followPeopleRecyclerView = findViewById(R.id.followPeopleRecyclerView);

        followPeopleRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        discoverPeopleAdapter = new DiscoverPeopleAdapter(this, discoverPeopleList);
        followPeopleRecyclerView.setAdapter(discoverPeopleAdapter);


        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.discover_people_layout, null);

        followButton = view.findViewById(R.id.follow);

        Intent getUsersData = getIntent();

        if ( getUsersData != null ) {

            ArrayList<String> namesList = getUsersData.getStringArrayListExtra("namesList");
            ArrayList<String> fullNamesList = getUsersData.getStringArrayListExtra("fullNamesList");

            //setBitmapList = BitmapDataTransfer.getBitmapPicture();

            Log.i("info", BitmapDataTransfer.getBitmapPicture().size()+"");



            for (int i=0; i<namesList.size(); i++) {

                discoverPeopleList.add(new DiscoverPeopleModel( BitmapDataTransfer.getBitmapPicture().get(i), namesList.get(i), fullNamesList.get(i), R.drawable.cancel_image));
                discoverPeopleAdapter.notifyDataSetChanged();

            }

        }

/*
        ParseQuery<ParseObject> query = ParseQuery.getQuery("ProfilePicture");
        query.whereNotEqualTo("username", ParseUser.getCurrentUser().getUsername());
        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if (objects.size() > 0) {

                        for (ParseObject object : objects) {

                            ParseFile file = (ParseFile) object.get("picture");

                            String imageURL = file.getUrl();
                            file.getDataInBackground(new GetDataCallback() {
                                @Override
                                public void done(byte[] data, ParseException e) {
                                    if (e == null) {
                                        if (data != null) {
                                            String fullName = (String) object.get("username");
                                            String[] splitName = (fullName).split(" ");
                                            discoverPeopleList.add(new DiscoverPeopleModel(data, R.drawable.cancel_image, splitName[0],fullName));
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
*/


       /* if ( ParseUser.getCurrentUser().getList("following").contains(splitName[0]) ) {
            followButton.setEnabled(false);
            followButton.setAlpha(0.4f);
            followButton.setText("Followed");
        }
        */

        forward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiscoverPeopleActivity.this, HomePageActiviy.class);
                startActivity(intent);
            }

        });


    }
}


/*

                                            ParseQuery<ParseObject> followqQuery = ParseQuery.getQuery("UserFollowings");
                                            followqQuery.whereEqualTo("username", ParseUser.getCurrentUser().getUsername());
                                            followqQuery.findInBackground(new FindCallback<ParseObject>() {
                                                @Override
                                                public void done(List<ParseObject> objects, ParseException e) {
                                                    if (e == null) {
                                                        if (objects != null) {
                                                            List<String> followedUsersList = objects.get(0).getList("following");

                                                            ParseQuery<ParseUser> userNames = ParseUser.getQuery();
                                                            userNames.whereNotEqualTo("username", ParseUser.getCurrentUser().getUsername());
                                                            userNames.findInBackground(new FindCallback<ParseUser>() {
                                                                @Override
                                                                public void done(List<ParseUser> objects, ParseException e) {
                                                                    if ( e == null ) {
                                                                        if ( objects != null ) {
                                                                            for( ParseObject object : objects ) {
                                                                                String fullName = (String) object.get("username");
                                                                                String[] splitName = (fullName).split(" ");


                                                                                if (followedUsersList != null) {
                                                                                    if (followedUsersList.contains(splitName[0])) {
                                                                                        Log.i("info", splitName[0]);
                                                                                        //Log.i("info", String.valueOf(followedUsersList.contains(splitName[0])));

                                                                                        followButton.setEnabled(false);
                                                                                        followButton.setAlpha(0.4f);
                                                                                        followButton.setText("Followed");

                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            });


                                                        }
                                                    }
                                                }
                                            });


*/