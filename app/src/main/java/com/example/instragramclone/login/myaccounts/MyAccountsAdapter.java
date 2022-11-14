package com.example.instragramclone.login.myaccounts;

import static com.example.instragramclone.R.*;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

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

        View view = LayoutInflater.from(context).inflate(layout.my_accounts_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyAccountsModel myAccountsModel = myAcc.get(position);
        holder.myImage.setImageResource(myAccountsModel.myImage);
        holder.username.setText(myAccountsModel.username);
        holder.remove_from_list.setImageResource(myAccountsModel.remove_from_list);

        Dialog dialog = new Dialog(context);
        dialog.setContentView(layout.remove_myacc_from_list_layout);
        dialog.getWindow().setBackgroundDrawableResource(drawable.remove_acc_round_corners);
        dialog.setCancelable(false);

        holder.remove_from_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView removeAccTextView = dialog.findViewById(id.removeAccTextView);
                removeAccTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if ( myAcc.size() > 0 ) {
                            myAcc.remove(holder.getAdapterPosition());
                            notifyDataSetChanged();
                            dialog.dismiss();
                        }

                    }
                });

                TextView cancelTextView = dialog.findViewById(id.cancleTextView);
                cancelTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return myAcc.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView myImage, remove_from_list;
        TextView username;
        Button followButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myImage = itemView.findViewById(id.personImage);
            username = itemView.findViewById(id.personName);
            remove_from_list = itemView.findViewById(id.remove_from_list);
            followButton = itemView.findViewById(id.follow);


        }
    }
    

}
