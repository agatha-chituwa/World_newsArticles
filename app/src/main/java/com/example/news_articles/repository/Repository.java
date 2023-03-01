package com.example.news_articles.repository;



import com.example.news_articles.articles.ArticleNetworkResponse;
import com.example.news_articles.articlesApii.APIclient;
import com.example.news_articles.articlesApii.NewsService;



import rx.Observable;
import rx.Single;

import static com.example.news_articles.utils.Constants.API_KEY;

public class Repository {

    private static Repository instance;


    public Single<ArticleNetworkResponse> getArticles() {
        return APIclient.getInstance().getApi().getNewsArticles(API_KEY, "bitcoin");
    }

    // singleton instance
    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }
}
