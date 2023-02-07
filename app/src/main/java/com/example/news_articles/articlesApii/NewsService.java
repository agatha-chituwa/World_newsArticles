package com.example.news_articles.articlesApii;

import com.example.news_articles.articles.ArticleNetworkResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;

public interface NewsService {

    @GET("top-headlines?country=us")
    Single<ArticleNetworkResponse> getNewsArticles(@Query("key") String key);

}
