package com.example.instragramclone.signup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instragramclone.R;
import com.example.instragramclone.signup.discoverpeople.DiscoverPeopleActivity;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddPhotoActivity extends AppCompatActivity {

    TextView skipToAdd;
    Button addPhotoButton;
    private static int REQ_CODE = 1;

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Intent pic = result.getData();
            if ( pic != null ) {
                Uri uri = pic.getData();
                if ( uri != null ) {
                    try {
                        Bitmap myBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();


                            /* now convert the our image into parse file which will be uploaded as part of
                               our parse object on parse server. */

                        // now we have the bitmap in png, high quality formate.

                        myBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);


                        // now convert it into byte array.
                        byte[] byteArray = stream.toByteArray();


                        // then finally covert that to parse file, we need byte array to store image on parser server
                        ParseFile file = new ParseFile("image.png", byteArray);

                        ParseObject userProfilePicture = new ParseObject("ProfilePicture");

                        userProfilePicture.put("username", ParseUser.getCurrentUser().getUsername());
                        userProfilePicture.put("picture", file);

                        userProfilePicture.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if ( e == null ) {
                                    Toast.makeText(AddPhotoActivity.this, "Image saved.", Toast.LENGTH_SHORT).show();
                                    Intent gotoDiscoverPeopleActivity = new Intent(AddPhotoActivity.this, DiscoverPeopleActivity.class);
                                    startActivity(gotoDiscoverPeopleActivity);
                                } else {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });

    private void getPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activityResultLauncher.launch(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if ( requestCode == 1 ) {
            if ( grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getPhoto();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        skipToAdd = findViewById(R.id.skipToAdd);
        addPhotoButton = findViewById(R.id.addPhotoButton);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if ( checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQ_CODE);
            }
        }

        addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPhoto();
            }
        });



        skipToAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddPhotoActivity.this, DiscoverPeopleActivity.class);
                // pass image as well by intent right here
                startActivity(intent);
            }
        });



    }
}