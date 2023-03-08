package com.example.news_articles.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news_articles.R;
import com.example.news_articles.adapter.ArticlesViewAdapter;
import com.example.news_articles.articles.Article;
import com.example.news_articles.articles.ArticlesViewFactory;
import com.example.news_articles.articles.ArticlesViewModel;
import com.example.news_articles.databinding.FragmentHomeBinding;
import com.example.news_articles.ui.ArticleActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ArticlesViewAdapter.ArticleViewHolder.OnArticleClick {
    private static final String TAG = "HomeFragment";
    private ArticlesViewModel articlesViewModel;
    private FragmentHomeBinding binding;
    List<Article> articles;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        articlesViewModel= new ViewModelProvider(this, new ArticlesViewFactory()).get(ArticlesViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        articlesViewModel.getArticles();

        RecyclerView articlesRecyclerView = binding.articlesRecyclerView;
        articlesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        articlesViewModel.getArticles();
        articlesViewModel.articles.observe(getViewLifecycleOwner(), articleNetworkResponse -> {
            articles = articleNetworkResponse.getArticles();
            if(articles.size() > 0){
                ArticlesViewAdapter articlesViewAdapter = new ArticlesViewAdapter(new ArrayList<>(), this);
                articlesRecyclerView.setAdapter(articlesViewAdapter);
                articlesViewAdapter.articleList = articles;
                articlesViewAdapter.notifyDataSetChanged();
                Log.d("ey", "its okay ");

            }

        });


        //
        articlesViewModel.articles.observe(getViewLifecycleOwner(), articleNetworkResponse -> {

            List<Article> articles = articleNetworkResponse.getArticles();

            if (articles.size() > 0) {
                String description = articles.get(0).getDescription();
                binding.descriptionTextView.setText(description);
            }
        });


        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onArticleClick(int position) {
        Log.d(TAG, "onArticleClick: item clicked " + position);
        Intent intent = new Intent(getActivity(), ArticleActivity.class);
        startActivity(intent);
    }
}