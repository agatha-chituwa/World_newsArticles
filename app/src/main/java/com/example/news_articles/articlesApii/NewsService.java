package com.example.news_articles.articlesApii;

import com.example.news_articles.articles.ArticleNetworkResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;

public interface NewsService {

    @GET("top-headlines")
    Single<ArticleNetworkResponse> getNewsArticles(@Query("apiKey") String key, @Query("country") String country);

}
