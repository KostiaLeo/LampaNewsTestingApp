package com.example.lampanewstextingapp.restServices;

import com.example.lampanewstextingapp.restServices.pojoClasses.MyNews;

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
