package com.example.news_articles.articles;

import static com.example.news_articles.utils.Constants.API_KEY;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.load.engine.Engine;
import com.example.news_articles.articlesApii.APIclient;

import com.example.news_articles.articlesApii.NewsService;
import com.example.news_articles.repository.Repository;
import com.example.news_articles.utils.LoadingStatus;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ArticlesViewModel extends ViewModel {


    private final Repository repository;

    public ArticlesViewModel(Repository repository){
        this.repository = repository;
    }
    private static final String TAG = "ArticlesViewModel";


    public MutableLiveData<ArticleNetworkResponse> articles = new MutableLiveData<>();
    public MutableLiveData<LoadingStatus> loadingStatus = new MutableLiveData<>();


    public void getArticles() {
        loadingStatus.postValue(LoadingStatus.LOADING);
        repository.getInstance().getArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(articleNetworkResponse -> {
                    loadingStatus.postValue(LoadingStatus.FINISHED);
                    articles.postValue(articleNetworkResponse);
                }, error -> {
                    loadingStatus.postValue(LoadingStatus.ERROR);
                    Log.e(TAG, error.toString());
                });
    }
}