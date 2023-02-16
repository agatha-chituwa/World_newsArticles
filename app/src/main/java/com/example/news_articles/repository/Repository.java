package com.example.news_articles.repository;



import com.example.news_articles.articles.ArticleNetworkResponse;
import com.example.news_articles.articlesApii.APIclient;
import com.example.news_articles.articlesApii.NewsService;



import rx.Observable;
import rx.Single;

import static com.example.news_articles.utils.Constants.API_KEY;

public class Repository {


    private final NewsService apiService;

    public Repository() {
        apiService = APIclient.getInstance().getApi();
    }

    public Single<ArticleNetworkResponse> getArticles() {
        return apiService.getNewsArticles(API_KEY, "us");
    }

}
