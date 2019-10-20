package com.example.lampanewstextingapp.presenter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.lampanewstextingapp.model.NetworkService;
import com.example.lampanewstextingapp.model.pojoClasses.MyNews;
import com.example.lampanewstextingapp.model.pojoClasses.Results;
import com.example.lampanewstextingapp.ui.view.MainListAdapter.NewsAdapter;
import com.example.lampanewstextingapp.ui.view.Slider.TopNewsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class News {
    private MyNews myNews;
    private final ArrayList<Results> results = new ArrayList<>();
    private RecyclerView recyclerView;
    private ViewPager2 viewPager;

    //public News(RecyclerView recyclerView) {
    //    this.recyclerView = recyclerView;
    //}

    public News(ViewPager2 viewPager, RecyclerView recyclerView) {
        this.viewPager = viewPager;
        this.recyclerView = recyclerView;
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
            }
        });
        return results;
    }

    private void setRecyclerView(ArrayList<Results> results) {
        TopNewsAdapter topNewsAdapter = new TopNewsAdapter(results);
        viewPager.setAdapter(topNewsAdapter);
        NewsAdapter newsAdapter = new NewsAdapter(results);
        recyclerView.setAdapter(newsAdapter);
    }
}
