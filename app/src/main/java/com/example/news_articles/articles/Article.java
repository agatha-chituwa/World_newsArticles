package com.example.news_articles.articles;

import com.google.gson.annotations.SerializedName;
public class Article {

    @SerializedName("source")
    private String source ;

    @SerializedName("author")
    private String author ;

    @SerializedName("title")
    private String title ;

    @SerializedName("description")
    private String description ;

    @SerializedName(("url"))
    private String url ;

    @SerializedName("urlToImage")
    private String urlToImage ;

    @SerializedName("publishedAt")
    private String publishedAt ;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
