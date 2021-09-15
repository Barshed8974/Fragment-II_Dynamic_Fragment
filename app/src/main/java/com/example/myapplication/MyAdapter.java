package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    private List<Example> arraylist1=new ArrayList<>();

    public MyAdapter(List<Example> arraylist1) {
        this.arraylist1 = arraylist1;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Example responseItem= arraylist1.get(position);
        holder.setData(responseItem);
    }

    @Override
    public int getItemCount() {
        return arraylist1.size();
    }
}
