package com.example.lampanewstextingapp;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lampanewstextingapp.restServices.NetworkService;
import com.example.lampanewstextingapp.restServices.pojoClasses.MyNews;
import com.example.lampanewstextingapp.restServices.pojoClasses.Results;
import com.example.lampanewstextingapp.ui.main.NewsAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class News {
    private MyNews myNews;
    private final ArrayList<Results> results = new ArrayList<>();
    private RecyclerView recyclerView;

    public News(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public ArrayList<Results> getAllNews(){
        NetworkService.getInstance().getNewsApi().getAPINews("json").enqueue(new Callback<MyNews>() {
            @Override
            public void onResponse(Call<MyNews> call, Response<MyNews> response) {
                if(response.isSuccessful()){
                    myNews = response.body();
                    for (int i = 0; i < 10; i++) {
                        results.add(myNews.getResults()[i]);
                        System.out.println(myNews.getResults()[i].getImage().getHeight());
//                        resultsHashMap.put(String.valueOf(i), myNews.getResults()[i]);
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
    private void setRecyclerView(ArrayList<Results> results){
        NewsAdapter newsAdapter = new NewsAdapter(results);

        recyclerView.setAdapter(newsAdapter);
    }
}
