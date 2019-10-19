package com.example.lampanewstextingapp.restRervices;

import com.example.lampanewstextingapp.restRervices.pojoClasses.MyNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface INewsApi {
    @GET("api/v1.0/products/")
    Call<MyNews> getAPINews(
            //@Query("cursor") String cursor,
            @Query("format") String format
    );
}
