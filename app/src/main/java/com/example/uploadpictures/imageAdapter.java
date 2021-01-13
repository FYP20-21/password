package com.example.uploadpictures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.ViewHolder> {
    List<ShowImage> imageLists;
    Context ct;

    public imageAdapter(List<ShowImage> imageLists, Context ct){
        this.imageLists = imageLists;
        this.ct = ct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShowImage showImage = imageLists.get(position);
        Glide.with(ct).load(showImage.getImageUrl()).into(holder.img);
        holder.fname.setText(showImage.getFilename());
    }

    @Override
    public int getItemCount() {
        return imageLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton img;
        TextView fname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.showImageView);
            fname = itemView.findViewById(R.id.imageID);
        }
    }
}
