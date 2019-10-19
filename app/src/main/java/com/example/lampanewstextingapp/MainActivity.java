package com.example.lampanewstextingapp;

import android.os.Bundle;

import com.example.lampanewstextingapp.restRervices.NetworkService;
import com.example.lampanewstextingapp.restRervices.pojoClasses.MyNews;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.lampanewstextingapp.ui.main.SectionsPagerAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MyNews myNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        System.out.println("starting calling");
        getNews();
    }

    private void getNews(){
        System.out.println("resume network");//"cD0yMDE3LTEwLTA2KzEwJTNBMTUlM0E1NS4yMTY2NzAlMkIwMCUzQTAwJnI9MQ%3D%3D",
        NetworkService.getInstance().getNewsApi().getAPINews("json").enqueue(new Callback<MyNews>() {
            @Override
            public void onResponse(Call<MyNews> call, Response<MyNews> response) {
                System.out.println("response.body().getResults().length " + response.body().getResults().length);
                myNews = response.body();
                for (int i = 0; i < 10; i++) {
                    System.out.println(myNews.getResults()[i]);
                }
            }

            @Override
            public void onFailure(Call<MyNews> call, Throwable t) {
                System.out.println("something wrong\n " + t.getMessage());
            }
        });
        System.out.println("finish calling");
    }
}