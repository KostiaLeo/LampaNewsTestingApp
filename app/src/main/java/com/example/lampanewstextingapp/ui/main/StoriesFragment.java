package com.example.lampanewstextingapp.ui.main;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.print.PrinterId;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lampanewstextingapp.News;
import com.example.lampanewstextingapp.R;
import com.example.lampanewstextingapp.restServices.pojoClasses.Results;

public class StoriesFragment extends Fragment {
    private Context context;
    private RecyclerView newsRecycler;
    private int width;
    private StoriesFragment(Context context){
        this.context = context;
    }
    static StoriesFragment newInstance(Context context) {
        return new StoriesFragment(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_stories, container, false);
        newsRecycler = root.findViewById(R.id.products);
        newsRecycler.setLayoutManager(new LinearLayoutManager(context));
        News news = new News(newsRecycler);
        news.getAllNews();
        return root;
    }
}
