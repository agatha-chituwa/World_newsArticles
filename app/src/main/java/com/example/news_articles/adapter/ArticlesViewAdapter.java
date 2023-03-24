package com.example.news_articles.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.news_articles.R;
import com.example.news_articles.articles.Article;

import java.util.List;

public class ArticlesViewAdapter extends RecyclerView.Adapter<ArticlesViewAdapter.ArticleViewHolder> {
    public List<Article> articleList;
    //how viewHolder know the on article listener is
    private ArticleViewHolder.OnArticleClick onArticleClick;

    private static ArticlesViewAdapter articlesViewAdapter;
    public ArticlesViewAdapter(List<Article> articleList, ArticleViewHolder.OnArticleClick onArticleClick) {

        this.articleList = articleList;
        this.onArticleClick = onArticleClick;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artile_item, parent, false);
        return new ArticleViewHolder(view, onArticleClick);
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

    //changed viewLister by implementing onclickListener
    public static class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView titleTextView;
        private TextView descriptionTextView;
        private ImageView imageView;
        private TextView sourceTextView;
        private TextView publishedAtTextView;

        OnArticleClick onArticleClick;
        public ArticleViewHolder(@NonNull View itemView, OnArticleClick onArticleClick) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.tv_article_title);
            descriptionTextView = itemView.findViewById(R.id.tv_article_description);
            imageView = itemView.findViewById(R.id.iv_article_image);
            sourceTextView = itemView.findViewById(R.id.tv_article_source);
            publishedAtTextView = itemView.findViewById(R.id.tv_article_date);
            this.onArticleClick = onArticleClick;

            //attach listener to the entire view holder
            itemView.setOnClickListener(this);
        }

        public void bind(Article article) {
            titleTextView.setText( article.getTitle());
            descriptionTextView.setText( article.getDescription());
            sourceTextView.setText(article.getSource().getName());
            publishedAtTextView.setText(article.getPublishedAt());
            // Load the image using Glide library
            if (article.getUrlToImage() != null && !article.getUrlToImage().isEmpty()) {
                Glide.with(itemView.getContext())
                        .load(article.getUrlToImage())
                        .fitCenter()
                        .into(imageView);
            } else {
                Glide.with(itemView.getContext())
                        //this will be the default img
                        .load(R.drawable.images)
                        .into(imageView);
            }



        }



        //implemented method of Onclick listener class
        @Override
        public void onClick(View v) {
            onArticleClick.onArticleClick(getAdapterPosition());
        }

        public interface OnArticleClick{
            void onArticleClick(int position);
        }
    }
}