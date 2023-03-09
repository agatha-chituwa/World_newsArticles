package com.example.news_articles.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.news_articles.R;
import com.example.news_articles.articles.Article;

public class ArticleDetails extends AppCompatActivity {
    private static final String TAG = "ActivityDetails";
    TextView textView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private ImageView imageView;
    private TextView authorTextView;
    private TextView publishedAtTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);

        if (getIntent().hasExtra("selected article")) {
            Article article = getIntent().getParcelableExtra("selected article");
            titleTextView = findViewById(R.id.article_title);
            titleTextView.setText(article.getAuthor());

            descriptionTextView = findViewById(R.id.article_description);
            descriptionTextView.setText(article.getDescription());

//            publishedAtTextView = findViewById(R.id.publishedAtTextView);
//            publishedAtTextView.setText(article.getPublishedAt());
//
//            if (article.getUrlToImage() != null && !article.getUrlToImage().isEmpty()) {
//
//                Glide.with(imageView.getContext())
//                        .load(article.getUrlToImage())
//                        .placeholder(R.drawable.ic_dashboard_black_24dp)
//                        .into(imageView);
//            } else {
//                Glide.with(imageView.getContext())
//                        //this will be the default img
//                        .load(R.drawable.ic_launcher_background)
//                        .into(imageView);
//            }
//
//        }


//
//        intent.putExtra("title", news.getTitle());
//        intent.putExtra("description", news.getDescription());
//        intent.putExtra("image", news.getImageUrl());
//        intent.putExtra("content", news.getContent());
//        intent.putExtra("link", news.getLink());
//        context.startActivity(intent);

        }
    }
}