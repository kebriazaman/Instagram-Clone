package com.example.instragramclone.login.myaccounts;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instragramclone.R;

import java.util.ArrayList;

public class MyAccountsAdapter extends RecyclerView.Adapter<MyAccountsAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyAccountsModel> myAcc;

    public MyAccountsAdapter(Context context, ArrayList<MyAccountsModel> myAcc) {
        this.context = context;
        this.myAcc = myAcc;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_accounts_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyAccountsModel myAccountsModel = myAcc.get(position);

        holder.myImage.setImageResource(myAccountsModel.myImage);
        holder.username.setText(myAccountsModel.username);
    }

    @Override
    public int getItemCount() {
        return myAcc.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView myImage, remove_from_list;
        TextView username;
        Button follow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myImage = itemView.findViewById(R.id.personImage);
            username = itemView.findViewById(R.id.personName);
            follow = itemView.findViewById(R.id.follow);
            remove_from_list = itemView.findViewById(R.id.remove_from_list);

        }
    }
    

}
