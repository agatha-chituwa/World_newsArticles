package com.example.news_articles.db;
//import android.arch.persistence.room.TypeConverter;


import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.news_articles.articles.Source;

public class SourceConvetor {

    @TypeConverter
    public String convertFromSource(Source source){

        return source.getName();
    }
}
