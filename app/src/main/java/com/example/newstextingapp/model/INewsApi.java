package com.example.newstextingapp.model;

import com.example.newstextingapp.model.pojoClasses.MyNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/*
 * Author - Levitskiy Konstantin
 */
// Interface which defines call GET-operation
public interface INewsApi {
    @GET("api/v1.0/products/")
    Call<MyNews> getAPINews(
            @Query("format") String format
    );
}
