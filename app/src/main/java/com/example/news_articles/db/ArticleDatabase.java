package com.example.news_articles.db;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Article.class}, version = 1)
@TypeConverters({SourceConvetor.class})
public abstract class ArticleDatabase extends RoomDatabase {
   public abstract ArticleDao articleDao();

    private static final String DB_NAME = "articleDatabase" ;
    private static volatile ArticleDatabase INSTANCE;


    static  ArticleDatabase getDatabase(final Context context){
        if(INSTANCE == null) {
            synchronized (ArticleDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ArticleDatabase.class, DB_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }



}
