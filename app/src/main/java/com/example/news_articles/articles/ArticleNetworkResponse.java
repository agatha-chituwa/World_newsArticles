package com.example.news_articles.articles;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleNetworkResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    private List<Article> articles;

    public ArticleNetworkResponse() {
    }

    public ArticleNetworkResponse(String status,
                                  int totalResults,
                                  List<Article> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
