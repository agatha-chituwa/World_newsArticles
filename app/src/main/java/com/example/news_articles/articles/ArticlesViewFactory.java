package com.example.news_articles.articles;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.news_articles.repository.Repository;

import org.jetbrains.annotations.NotNull;

public class ArticlesViewFactory implements ViewModelProvider.Factory {
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(ArticlesViewModel.class)){
            return (T) new ArticlesViewModel(Repository.getInstance() );
        }throw new IllegalArgumentException("unknown viewModel");

    }
}
