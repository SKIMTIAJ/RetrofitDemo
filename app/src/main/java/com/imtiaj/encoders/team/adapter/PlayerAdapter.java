package com.imtiaj.encoders.team.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imtiaj.encoders.R;
import com.imtiaj.encoders.team.model.PlayerChildObject;
import com.imtiaj.encoders.team.model.Team;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<PlayerChildObject> listPlayer;
    private ArrayList<Team> listTeam;


    public PlayerAdapter(Context mContext, ArrayList<PlayerChildObject> listPlayer, ArrayList<Team> listTeam) {
        this.mContext = mContext;
        this.listPlayer = listPlayer;
        this.listTeam = listTeam;
    }

    @NonNull
    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.player_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.ViewHolder holder, int position) {

        holder.fullName.setText(listPlayer.get(position).getFullname());
        holder.teamName.setText(listTeam.get(position).getName());
        holder.dateofBirth.setText(listPlayer.get(position).getDateofbirth());
        holder.gender.setText(listPlayer.get(position).getGender());
        Glide.with(mContext).load(listPlayer.get(position).getImage())
                .centerCrop()
                .circleCrop()
                .into(holder.profileImage);

    }

    @Override
    public int getItemCount() {
        return listPlayer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImage;
        TextView fullName,teamName,gender,dateofBirth;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.fullName);
            teamName = itemView.findViewById(R.id.teamName);
            gender = itemView.findViewById(R.id.gender);
            dateofBirth = itemView.findViewById(R.id.dateOfBirth);
            profileImage = itemView.findViewById(R.id.imagePlayer);


        }
    }


}
