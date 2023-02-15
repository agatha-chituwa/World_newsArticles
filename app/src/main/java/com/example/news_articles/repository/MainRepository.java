package com.example.news_articles.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.news_articles.articles.ArticleNetworkResponse;
import com.example.news_articles.articlesApii.APIclient;
import com.example.news_articles.articlesApii.NewsService;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.news_articles.utils.Constants.API_KEY;

public class MainRepository {
    private static final String TAG = "ArticlesRepository";

    private APIclient apiClient;

    public MutableLiveData<ArticleNetworkResponse> articles = new MutableLiveData<>();

    public MutableLiveData<ArticleNetworkResponse> getArticles() {

        APIclient.getInstance().getApi().getNewsArticles(API_KEY, "us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(articleNetworkResponse -> {
                    articles.postValue(articleNetworkResponse);

                }, error -> {
                    Log.e(TAG, error.toString());
                });
        return articles;
    }
}
