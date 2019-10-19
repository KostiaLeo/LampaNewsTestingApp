package com.example.lampanewstextingapp.ui.main;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lampanewstextingapp.R;
import com.example.lampanewstextingapp.restServices.pojoClasses.Image;
import com.example.lampanewstextingapp.restServices.pojoClasses.Results;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<ViewHolder>{
    private ArrayList<Results> results;

    public NewsAdapter(ArrayList<Results> results) {

        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Results result = results.get(position);
        final Image image = result.getImage();

//        if(result.getImage().getHeight() != null && result.getImage().getWidth() != null){
//            float h = Integer.parseInt(image.getHeight());
//            float w = Integer.parseInt(image.getWidth());
//
//            int height = (int) (h/w) * width;
//            holder.photo.setMaxWidth(width);
//            holder.photo.setMaxHeight(30);
//        }

        Glide.with(holder.itemView.getContext())
                .load(image.getUrl())
                .into(holder.photo);
        holder.nameTv.setText(result.getName());
        holder.costTv.setText("  -   " + result.getPrice());
        holder.typeTv.setText(result.getCurrency().getId());
    }

    @Override
    public int getItemCount() {
        if (results == null) {
            return 0;
        }
        return results.size();
    }
}
