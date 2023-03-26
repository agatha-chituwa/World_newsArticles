package com.example.news_articles.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news_articles.adapter.ArticlesViewAdapter;
import com.example.news_articles.articles.Article;
import com.example.news_articles.articles.ArticlesViewFactory;
import com.example.news_articles.articles.ArticlesViewModel;
import com.example.news_articles.databinding.FragmentHomeBinding;
import com.example.news_articles.ui.ArticleDetails;
import com.example.news_articles.utils.LoadingStatus;

import java.util.ArrayList;
import java.util.List;

import static com.example.news_articles.utils.Constants.TEXT_EXTRA;

public class HomeFragment extends Fragment implements ArticlesViewAdapter.ArticleViewHolder.OnArticleClick {
    private static final String TAG = "HomeFragment";
    private ArticlesViewModel articlesViewModel;
    private FragmentHomeBinding binding;
    private ProgressBar loadingAllArticleProgress;
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
        articlesViewModel.loadingStatus.observe(getViewLifecycleOwner(), loadingStatus->{
            switch (loadingStatus){
                case LOADING:
                    binding.loadingAllArticleProgress.setVisibility(View.VISIBLE);
                    break;
                case FINISHED:
                    binding.loadingAllArticleProgress.setVisibility(View.GONE);
                case ERROR:
                    binding.loadingAllArticleProgress.setVisibility(View.GONE);
                default:
                    break;
            }
        });
        articlesViewModel.articles.observe(getViewLifecycleOwner(), articleNetworkResponse -> {
            articles = articleNetworkResponse.getArticles();
            if(articles.size() > 0){
                //create and set the article at the initialization of the adapter
                ArticlesViewAdapter articlesViewAdapter = new ArticlesViewAdapter(articles, this);
                articlesRecyclerView.setAdapter(articlesViewAdapter);
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
        Intent intent = new Intent(getActivity(), ArticleDetails.class);
        intent.putExtra(TEXT_EXTRA, articles.get(position));
        startActivity(intent);
    }
}