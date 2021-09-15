package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView id;
    private ImageView image;
    public MyHolder(@NonNull View itemView) {
        super(itemView);
        initviews();
    }

    private void initviews() {
        name=itemView.findViewById(R.id.tvName);
        id=itemView.findViewById(R.id.tvId);
        image=itemView.findViewById(R.id.image);
    }
    public void setData(Example response)
    {
        name.setText(response.getName());
        id.setText(response.getId()+"");
        Glide.with(image).load(response.getOwner().getAvatarUrl()).into(image);
    }
}
