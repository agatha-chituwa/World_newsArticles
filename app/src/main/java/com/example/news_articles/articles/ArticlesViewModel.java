package com.example.news_articles.articles;

import static com.example.news_articles.utils.Constants.API_KEY;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.news_articles.articlesApii.APIclient;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ArticlesViewModel extends ViewModel {
    private static final String TAG = "ArticlesViewModel";

    public MutableLiveData<ArticleNetworkResponse> articles = new MutableLiveData<>();

    public void getArticles() {
        APIclient.getInstance().getApi().getNewsArticles(API_KEY, "us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(articleNetworkResponse -> {
                    articles.postValue(articleNetworkResponse);

                }, error -> {
                    Log.e(TAG, error.toString());
                });
    }
}
