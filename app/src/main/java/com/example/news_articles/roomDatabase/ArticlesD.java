package com.example.news_articles.roomDatabase;

import com.example.news_articles.articles.Source;
import com.google.gson.annotations.SerializedName;

//@Entity
public class ArticlesD {
    //@PrimaryKey(autoGenerate = true)
    //@ColumnInfo(name = "source")
    private Source source ;

    //@ColumnInfo(name = "author")
    private String author ;
    //@ColumnInfo(name = "title")
    private String title ;
    //@ColumnInfo(name = "description")
    private String description ;

    //@ColumnInfo(name = "url")

    private String url ;
    //@ColumnInfo(name = "urlToImage")
    private String urlToImage ;
    //@ColumnInfo(name = "publishedAt")
    private String publishedAt ;

    //@ColumnInfo(name = "content")
    private String content;
}
