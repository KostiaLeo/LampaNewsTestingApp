package com.example.newstextingapp.model;

import com.example.newstextingapp.model.pojoClasses.MyNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Single;

/*
 * Author - Levitskiy Konstantin
 */
// Interface which defines call GET-operation
public interface INewsApi {
    @GET("api/v1.0/products/")
    Observable<MyNews> getAPINews(
            @Query("format") String format
    );
    //    Call<MyNews> getAPINews(
//            @Query("format") String format
//    );
}
