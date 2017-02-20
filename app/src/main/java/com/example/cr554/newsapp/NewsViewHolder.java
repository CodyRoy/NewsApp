package com.example.cr554.newsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Created by cr554 on 2/17/2017.
 */

public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView headline;
    public TextView section;
    public ImageView thumbnail;
    private Context context;

    //constructor
    public NewsViewHolder(View itemView, Context ctx){
        super(itemView);
        headline = (TextView) itemView.findViewById(R.id.newsHeadline);
        section = (TextView) itemView.findViewById(R.id.newsSection);
        thumbnail = (ImageView) itemView.findViewById(R.id.newsImg);
        itemView.setOnClickListener(this);
        this.context = ctx;
    }

    public void onClick(View view){
        //opens a webview of the article
    }
}
