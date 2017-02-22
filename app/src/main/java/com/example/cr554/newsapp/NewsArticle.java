package com.example.cr554.newsapp;

/**
 * Created by cr554 on 2/20/2017.
 * The NewsArticle class sets and gets all relevant information regaurding the specific news article
 */

public class NewsArticle {
    private String mHeadline;
    private String mSectionName;
    private String mThumbnail;
    private String mUrl;

    NewsArticle(String vHeadline, String vSectionName, String vThumbnail, String vUrl) {
        mHeadline = vHeadline;
        mSectionName = vSectionName;
        mThumbnail = vThumbnail;
        mUrl = vUrl;
    }

    String getHeadline() {
        return mHeadline;
    }

    String getSectionName() {
        return mSectionName;
    }

    String getThumbnail() {
        return mThumbnail;
    }

    String getUrl() {
        return mUrl;
    }

}
