package com.example.cr554.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import com.example.cr554.newsapp.Volley.VolleySingleton;

/**
 * Created by cr554 on 2/17/2017.
 */

public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView headline;
    public TextView section;
    public NetworkImageView thumbnail;
    private Context context;

    //constructor
    public NewsViewHolder(View itemView, Context ctx){
        super(itemView);
        headline = (TextView) itemView.findViewById(R.id.newsHeadline);
        section = (TextView) itemView.findViewById(R.id.newsSection);
        thumbnail = (NetworkImageView) itemView.findViewById(R.id.newsImg);

        itemView.setOnClickListener(this);
        this.context = ctx;
    }

    public void bindNews(NewsArticle news){
        headline.setText(news.getHeadline());
        section.setText(news.getSectionName());
        thumbnail.setImageUrl(news.getThumbnail(),VolleySingleton.getInstance(context).getImageLoader());
    }

    public void onClick(View view){
        NewsArticle newsArticle = MainActivity.newsArticles.get(getAdapterPosition());
        Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(newsArticle.getUrl()));
        context.startActivity(browserIntent);
    }
}
