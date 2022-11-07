package com.example.instragramclone.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.instragramclone.R;
import com.example.instragramclone.signup.signupdataset.SignupConfirmActivity;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class ChangeUserNameActivity extends AppCompatActivity {

    Button next;
    EditText changeUserNameEditText;
    ImageView tick;

    private void placeCursroAtEnd() { changeUserNameEditText.setSelection(changeUserNameEditText.getText().length());}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_name);

        tick = findViewById(R.id.tick);
        next = findViewById(R.id.next);

        Intent intent = getIntent();
        changeUserNameEditText = findViewById(R.id.changeUserNameEditText);

        placeCursroAtEnd();

        changeUserNameEditText.setText(intent.getStringExtra("fullname"));

        changeUserNameEditText.addTextChangedListener(new TextWatcher() {@Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}@Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.length() >= 4) {
                    next.setEnabled(true);
                    next.setAlpha(1f);
                    placeCursroAtEnd();
                    tick.animate().translationZ(20);
                    tick.animate().scaleX(1).setDuration(500);
                    tick.animate().scaleY(1).setDuration(500);

                } else {
                    next.setEnabled(false);
                    next.setAlpha(0.4f);
                    tick.animate().translationZ(-20);
                    tick.animate().scaleX(-1).setDuration(500);
                    tick.animate().scaleY(-1).setDuration(500);
                }

            }

        });

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.register_changed_name);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseUser currentUser = new ParseUser();

                currentUser.put("username", changeUserNameEditText.getText().toString());
                currentUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            dialog.show();
                            Intent intent = new Intent(ChangeUserNameActivity.this, SignupConfirmActivity.class);
                            startActivity(intent);
                        }
                    }
                });
                dialog.dismiss();
            }
        });

    }
}