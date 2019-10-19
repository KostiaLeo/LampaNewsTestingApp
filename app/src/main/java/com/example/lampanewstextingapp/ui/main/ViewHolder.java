package com.example.lampanewstextingapp.ui.main;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lampanewstextingapp.R;

public class ViewHolder extends RecyclerView.ViewHolder{
    TextView costTv, nameTv, typeTv;
    ImageView photo;
    ViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTv = itemView.findViewById(R.id.name);
        costTv = itemView.findViewById(R.id.cost);
        typeTv = itemView.findViewById(R.id.type);
        photo = itemView.findViewById(R.id.photo);
    }
}
