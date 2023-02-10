package com.example.news_articles.articlesApii;



import static com.example.news_articles.utils.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIclient {


    private static APIclient instance;

    private NewsService newsService;



    private  APIclient (){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
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
