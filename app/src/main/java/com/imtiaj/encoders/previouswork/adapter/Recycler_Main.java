package com.imtiaj.encoders.previouswork.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imtiaj.encoders.R;
import com.imtiaj.encoders.previouswork.model.BeautyAndSpa;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Recycler_Main extends RecyclerView.Adapter<Recycler_Main.ViewHolder> {

    private List<BeautyAndSpa> modelClassList;
    private Context ctx;
    public Recycler_Main(List<BeautyAndSpa> modelClassList,Context ctx) {
        this.modelClassList = modelClassList;
        this.ctx = ctx;
    }


    @NonNull
    @Override
    public Recycler_Main.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.parent_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_Main.ViewHolder holder, int position) {
        String namePerson = modelClassList.get(position).getServiceName();
        holder.name.setText(namePerson);
        Glide.with(ctx)
                .load(modelClassList.get(position).getImageUrl())
                .centerCrop()
                .circleCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ConstraintLayout ParentLay;
         ImageView imageView;
         TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ParentLay = (ConstraintLayout)itemView.findViewById(R.id.ParentText);
            imageView = (ImageView)itemView.findViewById(R.id.circleImage);
            name = (TextView)itemView.findViewById(R.id.serviceName);

        }
    }
}
