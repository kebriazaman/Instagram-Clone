package com.example.instragramclone.signup.discoverpeople;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instragramclone.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class DiscoverPeopleAdapter extends RecyclerView.Adapter<DiscoverPeopleAdapter.myViewHolder> {

    Context context;
    ArrayList<DiscoverPeopleModel> discoverPeopleList;

    public DiscoverPeopleAdapter(Context context, ArrayList<DiscoverPeopleModel> discoverPeopleList){
        this.context = context;
        this.discoverPeopleList = discoverPeopleList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discover_people_layout, parent, false);
        myViewHolder viewholder = new myViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        DiscoverPeopleModel discoverPeopleModel = discoverPeopleList.get(position);

        Bitmap myBitmap = BitmapFactory.decodeByteArray(discoverPeopleModel.data, 0, discoverPeopleModel.data.length);

        ImageView myImageView = new ImageView(context);
        myImageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        myImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        myImageView.setImageBitmap(myBitmap);
        myImageView.setImageBitmap(myBitmap);
        holder.cardView.addView(myImageView);

        holder.personName.setText(discoverPeopleModel.name);
        holder.personFullName.setText(discoverPeopleModel.fullName);
        holder.remove_from_list.setImageResource(discoverPeopleModel.remove);
        holder.remove_from_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                discoverPeopleList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();

            }
        });


        ParseQuery<ParseObject> query = ParseQuery.getQuery("UserFollowings");
        query.whereEqualTo("username", ParseUser.getCurrentUser().getUsername());
        query.orderByDescending("updatedAt");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if ( e == null ) {
                    if ( objects != null ) {
                        if ( objects.get(0).getList("following").contains(String.valueOf(holder.personName.getText())) ) {
                            holder.followButton.setEnabled(false);
                            holder.followButton.setAlpha(0.4f);
                            holder.followButton.setText("Followed");
                        } else {
                            Toast.makeText(context, "did not go there", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });



        holder.followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /*ParseObject followings = new ParseObject("UserFollowings");
                followings.put("username", ParseUser.getCurrentUser().getUsername());
                followings.addUnique("following", holder.personName.getText().toString());
                followings.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if ( e == null ){

                            Toast.makeText(context, "You are now following " + holder.personName.getText(), Toast.LENGTH_SHORT).show();
                        } else {
                            Log.i("info", "can not be followed");
                        }
                    }
                });
*/
                holder.followButton.setEnabled(false);
                holder.followButton.setAlpha(0.4f);
                holder.followButton.setText("Followed");

            }
        });

    }

    @Override
    public int getItemCount() { return discoverPeopleList.size(); }



    public class myViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView remove_from_list, personImage;
        TextView personName, personFullName;
        Button followButton;

        public myViewHolder(View view) {
            super(view);

            cardView = view.findViewById(R.id.cardView);

            personImage = view.findViewById(R.id.personImage);
            remove_from_list = view.findViewById(R.id.remove_from_list);

            personName = view.findViewById(R.id.personName);
            personFullName = view.findViewById(R.id.personFullName);

            followButton = view.findViewById(R.id.follow);

        }
    }

}
