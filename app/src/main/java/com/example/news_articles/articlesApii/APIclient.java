package com.example.news_articles.articlesApii;

import com.example.news_articles.utils.Constants;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class APIclient {


    private static APIclient instance;

    private static Retrofit retrofit;
    private NewsService newsService;
    private Constants constants;


    private  APIclient (){
        retrofit = new Retrofit.Builder()
                .baseUrl(constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        newsService = retrofit.create(NewsService.class);
    }

    public static APIclient getInstance() {
        if (instance == null) {
            instance = new APIclient();
        }
        return instance;
    }


    
}
