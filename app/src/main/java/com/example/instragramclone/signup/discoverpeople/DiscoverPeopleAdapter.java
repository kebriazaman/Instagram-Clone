package com.example.instragramclone.signup.discoverpeople;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instragramclone.R;

import java.util.ArrayList;

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

        DiscoverPeopleModel discoverPeopleModule = discoverPeopleList.get(position);
        holder.personImage.setImageResource(discoverPeopleModule.image);
        holder.personName.setText(discoverPeopleModule.name);
        holder.personFullName.setText(discoverPeopleModule.fullName);
        holder.remove_from_list.setImageResource(discoverPeopleModule.remove);

        holder.remove_from_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                discoverPeopleList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() { return discoverPeopleList.size(); }



    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView personImage, remove_from_list;
        TextView personName, personFullName;

        public myViewHolder(View view) {
            super(view);

            personImage = view.findViewById(R.id.personImage);
            remove_from_list = view.findViewById(R.id.remove_from_list);

            personName = view.findViewById(R.id.personName);
            personFullName = view.findViewById(R.id.personFullName);

        }
    }

}
