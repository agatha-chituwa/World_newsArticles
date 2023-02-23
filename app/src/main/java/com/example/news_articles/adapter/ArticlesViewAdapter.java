package com.example.news_articles.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.news_articles.R;
import com.example.news_articles.articles.Article;
import com.example.news_articles.articlesApii.APIclient;

import java.util.List;

public class ArticlesViewAdapter extends RecyclerView.Adapter<ArticlesViewAdapter.ArticleViewHolder> {
    public List<Article> articleList;

    private static ArticlesViewAdapter articlesViewAdapter;
    public ArticlesViewAdapter(List<Article> articleList) {

        this.articleList = articleList;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.bind(article);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView descriptionTextView;
        private ImageView imageView;
        private TextView sourceTextView;
        private TextView publishedAtTextView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            imageView = itemView.findViewById(R.id.imageView);
            sourceTextView = itemView.findViewById(R.id.sourceTextView);
            publishedAtTextView = itemView.findViewById(R.id.publishedAtTextView);
        }

        public void bind(Article article) {
            titleTextView.setText("Title:" + article.getTitle());
            descriptionTextView.setText( article.getDescription());
            sourceTextView.setText("source:" + article.getSource().getName());
            publishedAtTextView.setText("published Date:" +article.getPublishedAt());
            // Load the image using Glide library
            if (article.getUrlToImage() != null && !article.getUrlToImage().isEmpty()) {
                Glide.with(itemView.getContext())
                        .load(article.getUrlToImage())
                        .into(imageView);
            } else {
                imageView.setVisibility(View.GONE);
            }



        }
    }
}