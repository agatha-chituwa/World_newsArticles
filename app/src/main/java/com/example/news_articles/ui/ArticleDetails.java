package com.example.news_articles.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.news_articles.MainActivity;
import com.example.news_articles.R;
import com.example.news_articles.articles.Article;

import java.text.DateFormat;
import java.util.Calendar;

import static com.example.news_articles.utils.Constants.TEXT_EXTRA;

public class ArticleDetails extends AppCompatActivity {
    private ProgressBar loadingArticle;
    private WebView webView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        loadingArticle = findViewById(R.id.loadArticleProgressBar);



        if (getIntent().hasExtra(TEXT_EXTRA)) {
            Article article = getIntent().getParcelableExtra(TEXT_EXTRA);
//
            this.setTitle(article.getTitle());
            //displays the back button icon
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setDisplayShowHomeEnabled(true);


            webView = findViewById(R.id.webview);
            webView.getSettings().setJavaScriptEnabled(true);
            //enable zooming in, for good view on small screens
            webView.getSettings().setSupportZoom(true);
            //in built zoom controls
            webView.getSettings().setBuiltInZoomControls(true);


            //tracks loading page progress
            webView.setWebViewClient(new WebViewClient() {
               @Override
                public void onPageFinished(WebView view, String url) {
                    loadingArticle.setVisibility(View.GONE);
                }
            });

            webView.loadUrl(article.getUrl());

        }
    }

    //get the user back when clicked
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}