package com.example.cr554.newsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cr554 on 2/17/2017.
 * try without buttknife :^)
 */

public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public @Bind(R.id.newsHeadline) TextView headline;
    public @Bind(R.id.newsSection) TextView section;
    public @Bind(R.id.newsImg) ImageView thumbnail;
    private Context mContext;

    //constructor
    public NewsViewHolder(View itemView, Context context){
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        this.mContext = context;
    }

    public void onClick(View view){
        //opens a webview of the article
    }
}
