package com.example.news_articles.articles;

import com.google.gson.annotations.SerializedName;
public class NetworkResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("articles")
    private String articles;
}
