package com.example.instragramclone.signup.signupdataset;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instragramclone.R;
import com.example.instragramclone.signup.AddPhotoActivity;
import com.example.instragramclone.signup.ChangeUserNameActivity;
import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.ArrayList;
import java.util.List;

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

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.register_changed_name);

        String[] splitUserName = (getDataSet.getStringExtra("email")).split("@");

        name.setText(splitUserName[0]+"?");

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();

                ParseUser user = new ParseUser();
                user.setEmail(getDataSet.getStringExtra("email"));
                user.setUsername(getDataSet.getStringExtra("fullname"));
                user.setPassword(getDataSet.getStringExtra("userpassword"));
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if ( e == null ) {
                            Toast.makeText(SignupConfirmActivity.this, ParseUser.getCurrentUser().getUsername()+" singed up.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignupConfirmActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                // Retriveing data from server.
                ParseQuery<ParseObject> query = ParseQuery.getQuery("ProfilePicture");
                query.whereNotEqualTo("username", ParseUser.getCurrentUser().getUsername());
                query.orderByDescending("updatedAt");
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if ( e == null) {

                            ArrayList<String> namesList = new ArrayList<>();
                            ArrayList<String> fullNamesList = new ArrayList<>();
                            ArrayList<Bitmap> picturesList = new ArrayList<>();


                            if ( objects != null) {
                                for (ParseObject object : objects) {

                                    String[] splitUsername = (object.get("username").toString()).split(" ");

                                    namesList.add(splitUsername[0]);
                                    fullNamesList.add(String.valueOf(object.get("username")));
                                    ParseFile file = (ParseFile) object.get("picture");

                                    file.getDataInBackground(new GetDataCallback() {
                                        @Override
                                        public void done(byte[] data, ParseException e) {
                                            if ( e == null ) {
                                                if (data != null) {

                                                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                                                    picturesList.add(bitmap);

                                                    if ( picturesList.size() == namesList.size() ) {
                                                        dialog.dismiss();
                                                        BitmapDataTransfer.setBitmapPicture(picturesList);
                                                        Intent intent = new Intent(SignupConfirmActivity.this, AddPhotoActivity.class);

                                                        intent.putStringArrayListExtra("namesList", namesList);
                                                        intent.putStringArrayListExtra("fullNamesList", fullNamesList);
                                                        startActivity(intent);

                                                    }

                                                }
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    }
                });
            }
        });



        chageUserNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupConfirmActivity.this, ChangeUserNameActivity.class);
                intent.putExtra("fullname", splitUserName[0]);
                startActivity(intent);
            }

        });

    }
}