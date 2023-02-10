package com.example.news_articles.articles;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.news_articles.articlesApii.APIclient;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static com.example.news_articles.utils.Constants.API_KEY;

public class ArticlesViewModel extends ViewModel {

    public MutableLiveData<ArticleNetworkResponse> articles = new MutableLiveData<>();

    public void getArticles() {
        APIclient.getInstance().getApi().getNewsArticles(API_KEY, "us")
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(articleNetworkResponse -> {
                    articles.postValue(articleNetworkResponse);

                }, error -> {

                });
    }
}
