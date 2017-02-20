package com.example.cr554.newsapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cr554.newsapp.NewsArticle;
import com.example.cr554.newsapp.NewsViewHolder;
import com.example.cr554.newsapp.R;

import java.util.List;

/**
 *
 * Created by cr554 on 2/17/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>{
    //
    private List<NewsArticle> mNewsArticles;
    private Context mContext;

    //Constructor
    public NewsAdapter(Context context, List<NewsArticle> newsArticles){
        this.mNewsArticles = newsArticles;
        this.mContext=context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_article_item_list, null);
        NewsViewHolder nvh = new NewsViewHolder(layoutView, mContext);
        return nvh;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position){
        NewsArticle currentArticle = mNewsArticles.get(position);
        String articleHeadline = currentArticle.getHeadline();
        String articleSection = currentArticle.getSectionName();
        String articleThumbnail = currentArticle.getThumbnail();
        holder.headline.setText(articleHeadline);
        holder.section.setText(articleSection);
        if(articleThumbnail.equals("")){
           holder.thumbnail.setVisibility(View.GONE);
        } else{
            //load image
        }
    }

    @Override
    public int getItemCount(){
        return this.mNewsArticles.size();
    }

}
