package com.example.lampanewstextingapp.ui.view.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.lampanewstextingapp.presenter.News;
import com.example.lampanewstextingapp.R;

public class StoriesFragment extends Fragment {
    private Context context;
    private RecyclerView newsRecycler;
    private ViewPager2 viewPager;
    private StoriesFragment(Context context) {
        this.context = context;
    }

    static StoriesFragment newInstance(Context context) {
        return new StoriesFragment(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_stories, container, false);
        newsRecycler = root.findViewById(R.id.newzzz);
        newsRecycler.setLayoutManager(new LinearLayoutManager(context));
        viewPager = root.findViewById(R.id.viewPager2);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        News news = new News(viewPager, newsRecycler);
        news.getAllNews();
        return root;
    }

}
