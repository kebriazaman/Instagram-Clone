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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.instragramclone.R;

public class ChangeUserNameActivity extends AppCompatActivity {

    Button next;
    EditText changeUserNameEditText;
    ImageView tick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_name);

        //TextView changeUserNameEditText = findViewById(R.id.changeUserNameEditText);
        tick = findViewById(R.id.tick);
        next = findViewById(R.id.next);
        changeUserNameEditText = findViewById(R.id.changeUserNameEditText);

        changeUserNameEditText.addTextChangedListener(new TextWatcher() {@Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }@Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if ( editable.length() > 3 ) {
                    tick.setVisibility(View.VISIBLE);
                    tick.bringToFront();
                } else {
                    tick.setVisibility(View.INVISIBLE);
                }
            }


        });

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.register_changed_name);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        dialog.dismiss();

    }
}