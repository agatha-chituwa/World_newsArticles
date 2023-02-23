package com.example.news_articles.ui.home;

import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private ArticlesViewModel articlesViewModel;
    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        articlesViewModel= new ViewModelProvider(this, new ArticlesViewFactory()).get(ArticlesViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        articlesViewModel.getArticles();

        RecyclerView articlesRecyclerView = binding.articlesRecyclerView;
        articlesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArticlesViewAdapter articlesViewAdapter = new ArticlesViewAdapter(new ArrayList<>());
        articlesRecyclerView.setAdapter(articlesViewAdapter);

        articlesViewModel.getArticles();
        articlesViewModel.articles.observe(getViewLifecycleOwner(), articleNetworkResponse -> {
            List<Article> articles = articleNetworkResponse.getArticles();
            articlesViewAdapter.articleList = articles;
            articlesViewAdapter.notifyDataSetChanged();
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
}