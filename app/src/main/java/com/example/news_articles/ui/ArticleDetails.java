package com.example.news_articles.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private Button openInBrowserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);

        if (getIntent().hasExtra("selected article")) {
            Article article = getIntent().getParcelableExtra("selected article");
            titleTextView = findViewById(R.id.article_title);
            titleTextView.setText(article.getTitle());

            descriptionTextView = findViewById(R.id.article_description);
            descriptionTextView.setText(article.getDescription());

            if (article.getUrlToImage() != null && !article.getUrlToImage().isEmpty()) {
                imageView = findViewById(R.id.article_image1);
                Glide.with(this).load(article.getUrlToImage()).into(imageView);
            } else {

                imageView = findViewById(R.id.article_image1);
                Glide.with(this).load(R.drawable.ic_launcher_background).into(imageView);
            }



            authorTextView = findViewById(R.id.article_author);
            authorTextView.setText(article.getAuthor());

            publishedAtTextView = findViewById(R.id.article_published_date1);
            publishedAtTextView.setText(article.getPublishedAt());

            openInBrowserButton = findViewById(R.id.button);
            openInBrowserButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String articleUrl = article.getUrl();
                    if (articleUrl != null && !articleUrl.isEmpty()) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(articleUrl));
                        startActivity(browserIntent);
                    }
                }
            });

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