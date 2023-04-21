package com.example.news_articles.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import rx.Single;

@Dao
public interface ArticleDao {

//        @Query("SELECT * FROM Article")
//        Single<Article>  getAllArticles();
////        LiveData<Single<Article> > getAllArticles();

}
