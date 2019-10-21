package com.example.lampanewstextingapp.view.mainList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lampanewstextingapp.R;
import com.example.lampanewstextingapp.model.pojoClasses.Image;
import com.example.lampanewstextingapp.model.pojoClasses.Results;

import java.util.ArrayList;
/*
 * Author - Levitskiy Konstantin
 */
//Adapter for recycler view of main news list
public class NewsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Results> results;

    public NewsAdapter(ArrayList<Results> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Results result = results.get(position);
            final Image image = result.getImage();
            Glide.with(holder.itemView.getContext())
                    .load(image.getUrl())
                    .into(holder.photo);
            holder.nameTv.setText(result.getName());
            holder.costTv.setText("  -   " + result.getPrice());
            holder.typeTv.setText(result.getCurrency().getId());
    }

    @Override
    public int getItemCount() {
        return (results == null) ? 0 : results.size();
    }
}
