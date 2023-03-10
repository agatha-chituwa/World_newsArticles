package com.example.news_articles.articlesApii;

import com.example.news_articles.articles.ArticleNetworkResponse;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Single;


public interface NewsService {

    @GET("top-headlines")
    Single<ArticleNetworkResponse> getNewsArticles(@Query("apiKey") String apiKey, @Query("country") String country);

}
