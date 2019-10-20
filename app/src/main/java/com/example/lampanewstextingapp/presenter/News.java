package com.example.lampanewstextingapp.presenter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.lampanewstextingapp.model.NetworkService;
import com.example.lampanewstextingapp.model.pojoClasses.MyNews;
import com.example.lampanewstextingapp.model.pojoClasses.Results;
import com.example.lampanewstextingapp.view.mainList.NewsAdapter;
import com.example.lampanewstextingapp.view.slider.TopNewsAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class News {
    private MyNews myNews;
    private final ArrayList<Results> results = new ArrayList<>();
    private RecyclerView recyclerView;
    private ViewPager2 viewPager;
    private Context context;
    public News(ViewPager2 viewPager, RecyclerView recyclerView, Context context) {
        this.viewPager = viewPager;
        this.recyclerView = recyclerView;
        this.context = context;
    }

    public ArrayList<Results> getAllNews() {
        NetworkService.getInstance().getNewsApi().getAPINews("json").enqueue(new Callback<MyNews>() {
            @Override
            public void onResponse(Call<MyNews> call, Response<MyNews> response) {
                if (response.isSuccessful()) {
                    myNews = response.body();
                    for (int i = 0; i < myNews.getResults().length; i++) {
                        results.add(myNews.getResults()[i]);
                    }
                    setRecyclerView(results);
                }
            }

            @Override
            public void onFailure(Call<MyNews> call, Throwable t) {
                System.out.println("something wrong\n " + t.getMessage());
                Toast.makeText(context, "Сервер не отвечает, попробуйте позже", Toast.LENGTH_SHORT).show();
            }
        });
        return results;
    }

    private void setRecyclerView(ArrayList<Results> results) {
        //TopNewsAdapter topNewsAdapter = new TopNewsAdapter(results);
        viewPager.setAdapter(new TopNewsAdapter(results));
        //NewsAdapter newsAdapter = new NewsAdapter(results);
        recyclerView.setAdapter(new NewsAdapter(results));
    }
}