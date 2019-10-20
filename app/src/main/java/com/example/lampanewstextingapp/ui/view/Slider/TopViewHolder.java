package com.example.lampanewstextingapp.ui.view.Slider;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lampanewstextingapp.R;

public class TopViewHolder extends RecyclerView.ViewHolder {
    TextView costTv, nameTv, typeTv;
    ImageView photo;
    TopViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTv = itemView.findViewById(R.id.name_top);
        costTv = itemView.findViewById(R.id.cost_top);
        typeTv = itemView.findViewById(R.id.type_top);
        photo = itemView.findViewById(R.id.photo_top);
    }
}
