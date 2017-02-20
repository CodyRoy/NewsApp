package com.example.cr554.newsapp;

/**
 * Created by cr554 on 2/20/2017.
 */

public class NewsArticle {
    private String mHeadline;
    private String mSectionName;
    private String mThumbnail;
    private String mUrl;

    public NewsArticle(String vHeadline, String vSectionName, String vThumbnail, String vUrl) {
        this.mHeadline = vHeadline;
        this.mSectionName = vSectionName;
        this.mThumbnail = vThumbnail;
        this.mUrl = vUrl;
    }

    public String getHeadline() {
        return mHeadline;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public String getUrl() {
        return mUrl;
    }

}
