package com.example.news_articles.articles;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
public class Article implements Parcelable {

    @SerializedName("source")
    private Source source ;

    @SerializedName("author")
    private String author ;

    @SerializedName("title")
    private String title ;

    @SerializedName("description")
    private String description ;

    @SerializedName("url")
    private String url ;

    @SerializedName("urlToImage")
    private String urlToImage ;

    @SerializedName("publishedAt")
    private String publishedAt ;

    @SerializedName("content")
    private String content;

    public Article() {
    }

    public Article(Source source,
                   String author,
                   String title,
                   String description,
                   String url,
                   String urlToImage,
                   String publishedAt,
                   String content) {
        this.source = source;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    protected Article(Parcel in) {
        author = in.readString();
        title = in.readString();
        description = in.readString();
        url = in.readString();
        urlToImage = in.readString();
        publishedAt = in.readString();
        content = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public Source getSource() {
        return source;
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

    @Override
    public String toString() {
        return "Article{" +
                "source=" + source +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(author);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(urlToImage);
        dest.writeString(publishedAt);
        dest.writeString(content);
    }
    //parcelable is a way to pckage objects
}
