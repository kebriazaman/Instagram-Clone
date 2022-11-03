package com.example.instragramclone.login.myaccounts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.instragramclone.R;
import com.example.instragramclone.signup.SignUpActivity;

import java.util.ArrayList;

public class MyAccountsActivity extends AppCompatActivity {

    ArrayList<MyAccountsModel> myAcc;
    RecyclerView myAccountsRecyclerView;
    MyAccountsAdapter myAccountsAdapter;
    TextView signup, switchAccounts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_accounts);

        signup = findViewById(R.id.signup);
        switchAccounts = findViewById(R.id.switchAccounts);
        myAccountsRecyclerView = findViewById(R.id.myAccountsRecyclerView);

        myAcc = new ArrayList<>();
        myAcc.add(new MyAccountsModel(R.drawable.elon_musk, "Elon Musk", R.drawable.remove_menu));
        myAcc.add(new MyAccountsModel(R.drawable.faizi, "Faizi tatai", R.drawable.remove_menu));

        myAccountsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        myAccountsAdapter = new MyAccountsAdapter(MyAccountsActivity.this, myAcc);
        myAccountsRecyclerView.setAdapter(myAccountsAdapter);




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyAccountsActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}