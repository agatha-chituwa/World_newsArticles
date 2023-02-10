package com.example.news_articles.articlesApii;

import com.example.news_articles.utils.Constants;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

import static com.example.news_articles.utils.Constants.BASE_URL;

public class APIclient {


    private static APIclient instance;

    private NewsService newsService;



    private  APIclient (){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        newsService = retrofit.create(NewsService.class);
    }

    public static synchronized APIclient getInstance() {
        if (instance == null) {
            instance = new APIclient();
        }
        return instance;
    }

    public NewsService getApi(){
        return newsService;
    }


    
}
