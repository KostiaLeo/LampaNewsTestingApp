package com.example.newstextingapp.presenter;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.newstextingapp.model.NetworkService;
import com.example.newstextingapp.model.pojoClasses.MyNews;
import com.example.newstextingapp.model.pojoClasses.Results;
import com.example.newstextingapp.view.mainList.NewsAdapter;
import com.example.newstextingapp.view.slider.TopNewsAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.schedulers.Schedulers;
/*
 * Author - Levitskiy Konstantin
 */
// presenter connects model and ui

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

    // Main method for receiving arraylist of results
    public ArrayList<Results> getAllNews() {
//        NetworkService.getInstance().getNewsApi().getAPINews("json").enqueue(new Callback<MyNews>() {
//            @Override
//            public void onResponse(Call<MyNews> call, Response<MyNews> response) {
//                if (response.isSuccessful()) {
//                    myNews = response.body();
//                    for (int i = 0; i < myNews.getResults().length; i++) {
//                        results.add(myNews.getResults()[i]);
//                    }
//                    setRecyclerView(results);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MyNews> call, Throwable t) {
//                System.out.println("something wrong\n " + t.getMessage());
//                Toast.makeText(context, "Сервер не отвечает, попробуйте позже", Toast.LENGTH_SHORT).show();
//            } 
//        });

        final Observable<MyNews> newsObservable = NetworkService.getInstance().getNewsApi().getAPINews("json");

        final Observable<Long> observableInterval = Observable.interval(1000, TimeUnit.MILLISECONDS);
        newsObservable.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .retryWhen(observableErrors -> {
                    System.out.println("RetryWhen");
                    return Observable.zip(Observable.range(1, 3), newsObservable, observableInterval, observableErrors, (integer, myNews, aLong, throwable) -> { // (Func4<Integer, MyNews, Long, Throwable, Observable>)
                        if (integer < 3) {
                            return Observable.just(0L);
                        } else {
                            return Observable.error(throwable);
                        }
                    }).flatMap((Func1<Observable, Observable<?>>) observable -> observable);
//                        return observableErrors.zipWith(Observable.range(1, 3), new Func2<Throwable, Integer, Observable>() {
//                            @Override
//                            public Observable call(Throwable throwable, Integer integer) {
//                                if (integer < 3) {
//                                    return Observable.just(0L);
//                                } else {
//                                    return Observable.error(throwable);
//                                }
//                            }
//                        }).flatMap(new Func1<Observable, Observable<?>>() {
//                            @Override
//                            public Observable<?> call(Observable observable) {
//                                return observable;
//                            }
//                        });
                })
                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<MyNews>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError throwable:" + e);
//                        Toast.makeText(context, "Сервер не отвечает, попробуйте позже", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onNext(MyNews myNews){
//                        System.out.println("onNext()");
//                        results.addAll(Arrays.asList(myNews.getResults()));
//                        setRecyclerView(results);
//                    }
//                });
        .subscribe(
                myNews -> {
                    results.addAll(Arrays.asList(myNews.getResults()));
                    setRecyclerView(results);
                },
                throwable -> {
                    System.out.println("onError throwable:" + throwable);
                    Toast.makeText(context, "Сервер не отвечает, попробуйте позже", Toast.LENGTH_SHORT).show();
                },
                () -> System.out.println("onCompleted")
        );
        System.out.println("Results size = " + results.size());
        return results;
    }

    // Giving results into view-class
    private void setRecyclerView(ArrayList<Results> results) {
        viewPager.setAdapter(new TopNewsAdapter(results));
        recyclerView.setAdapter(new NewsAdapter(results));
    }
}