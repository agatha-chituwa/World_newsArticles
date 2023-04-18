package com.example.news_articles.articles;
import com.google.gson.annotations.SerializedName;


public class Source {

    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Source() {
    }

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

}
