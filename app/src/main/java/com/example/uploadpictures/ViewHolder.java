/*package com.example.uploadpictures;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


public class ViewHolder extends RecyclerView.ViewHolder {
    View view;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }

    public void setDetails(Context context, String image){
        ImageView mImageView = view.findViewById(R.id.imageView);

        Picasso.with(context).load(image).into(mImageView);

        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        itemView.startAnimation(animation);
    }
}*/