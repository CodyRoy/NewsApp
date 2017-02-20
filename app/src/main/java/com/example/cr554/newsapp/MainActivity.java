package com.example.cr554.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.example.cr554.newsapp.adapter.NewsAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static List<NewsArticle> newsArticles;
    RecyclerView newsList = (RecyclerView) findViewById(R.id.newsList);
    TextView emptyView = (TextView) findViewById(R.id.noNewsToShow);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsArticles = new ArrayList<>();
        newsList.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, newsArticles);
        newsList.setAdapter();
        fetchNews();
    }

    private void redrawRecyclerView(){
        if(newsArticles.isEmpty()){
            newsList.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        }
    }
}
