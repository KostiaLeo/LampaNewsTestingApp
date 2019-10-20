package com.example.lampanewstextingapp.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lampanewstextingapp.R;

public class VideoFragment extends Fragment {
    private Context context;

    private VideoFragment(Context context) {
        this.context = context;
    }

    static VideoFragment newInstance(Context context) {
        return new VideoFragment(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View root = inflater.inflate(R.layout.fragment_video, container, false);

        return inflater.inflate(R.layout.fragment_video, container, false);
    }
}
