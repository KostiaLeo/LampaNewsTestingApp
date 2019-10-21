package com.example.lampanewstextingapp.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.lampanewstextingapp.presenter.News;
import com.example.lampanewstextingapp.R;
/*
 * Author - Levitskiy Konstantin
 */
//Main fragment's class
public class StoriesFragment extends Fragment {
    private Context context;
    private ViewPager2 viewPager;
    private LinearLayout sliderDotsPanel;
    private final int countOfTopNews = 10;
    private ImageView[] dots;
    private int dotsCount;

    private StoriesFragment(Context context) {
        this.context = context;
    }
    //newInstance for private constructor
    static StoriesFragment newInstance(Context context) {
        return new StoriesFragment(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflating layout for fragment
        View root = inflater.inflate(R.layout.fragment_stories, container, false);
        RecyclerView newsRecycler = root.findViewById(R.id.newzzz);
        newsRecycler.setLayoutManager(new LinearLayoutManager(context));
        //viewpager for sliding
        viewPager = root.findViewById(R.id.viewPager2);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // dots for slider
        sliderDotsPanel = root.findViewById(R.id.SliderDots);
        sliderDotsPanel.bringToFront();
        dotsCount = countOfTopNews;
        dots = new ImageView[dotsCount];

        // creating dots panel and defining color (and other parameters) for each dot
        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(context);
            dots[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.dotgrey));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            params.gravity = Gravity.CENTER;
            sliderDotsPanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.dotblue));

        // if we change slider-item than color of dot changes
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                for (int j = 0; j < dotsCount; j++) {
                    dots[j].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.dotgrey));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.dotblue));
            }
        });

        News news = new News(viewPager, newsRecycler, context);
        news.getAllNews();
        return root;
    }

}
