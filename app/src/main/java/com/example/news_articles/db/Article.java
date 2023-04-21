package com.example.news_articles.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Article {




    @PrimaryKey
    public int aId;

    @ColumnInfo(name = "author")
    private String author ;

    @ColumnInfo(name = "title")
    private String title ;
    @ColumnInfo(name = "description")
    private String description ;

    @ColumnInfo(name = "url")
    private String url ;

    @ColumnInfo(name = "urlToImage")
    private String urlToImage ;

    @ColumnInfo(name = "publishedAt")
    private String publishedAt ;

    @ColumnInfo(name = "content")
    private String content;

    public int getaId() {
        return aId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }




    public void setUid(int aId) {
        this.aId = aId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
