package com.example.news_articles.articlesApii;


import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class APIclient {


    private static APIclient instance;
    private static final String BASE_URL = "";
    private static Retrofit retrofit;

    private  APIclient (){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public synchronized APIclient getInstance() {
        if (instance == null) {
            instance = new APIclient();
        }
        return instance;
    }

    public NewsService getApi(){
        return retrofit.create(NewsService.class);
    }
    
}
