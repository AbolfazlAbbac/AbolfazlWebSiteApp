package com.example.abolfazlwebsiteapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView postTitleTv;
        TextView postDescriptionTv;
        ImageView postPictureIv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            postTitleTv = itemView.findViewById(R.id.postTitleTv_rv_main);
            postDescriptionTv = itemView.findViewById(R.id.postDescriptionTv_rv_main);
            postPictureIv = itemView.findViewById(R.id.postPictureIV_rv_main);
        }

        public void bind(String title, String des, String imageURl) {
            postTitleTv.setText(title);
            postDescriptionTv.setText(des);
            Picasso.get().load(imageURl).error(R.drawable.baseline_priority_high_24).into(postPictureIv);
        }
    }
}
