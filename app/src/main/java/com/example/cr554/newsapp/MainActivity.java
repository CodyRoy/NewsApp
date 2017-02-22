package com.example.cr554.newsapp;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cr554.newsapp.Volley.VolleySingleton;
import com.example.cr554.newsapp.adapter.NewsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    RecyclerView newsList;
    TextView emptyView;
    public static List<NewsArticle> newsArticles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        newsList =(RecyclerView)findViewById(R.id.newsList);
        emptyView = (TextView)findViewById(R.id.noNewsToShow);

        fetchNews();
    }

    private void fetchNews(){
        String url = "http://content.guardianapis.com/search?show-fields=thumbnail&q=sports&api-key=e6678f97-7cd9-4156-88f7-f5f508c29ed3";
        JsonObjectRequest moreNews = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                //grab the array of json results and iterate through ti to create news article classes, we can then add these to the adapter.???
                JSONArray results;
                try{
                    results = response.getJSONObject("response").getJSONArray("results");
                    for(int i =0; i <results.length();i++) {
                        JSONObject currentResult = results.getJSONObject(i);
                        NewsArticle newsArticle = new NewsArticle
                                (currentResult.getString("webTitle"),
                                        currentResult.getString("sectionName"),
                                        currentResult.getJSONObject("fields").getString("thumbnail"),
                                        currentResult.getString("webUrl"));
                        newsArticles.add(newsArticle);
                        }
                    newsList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    NewsAdapter adapter = new NewsAdapter(MainActivity.this, newsArticles);
                    newsList.setAdapter(adapter);
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                //do things with error response
            }
        });
        VolleySingleton.getInstance(this).addToRequestQueue(moreNews);
    }

    private void redrawRecycler(){
        if(newsArticles.isEmpty()){
            newsList.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        }else{
            newsList.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
        newsList.getAdapter().notifyDataSetChanged();
    }

    private String getNewsUrl(){
        String baseUri = getString(R.string.baseuri);
        Uri u = Uri.parse(baseUri).buildUpon()
                .appendQueryParameter("api_key","e6678f97-7cd9-4156-88f7-f5f508c29ed3")
                .appendQueryParameter("format", "json")
                .appendQueryParameter("nojsoncallack","1")
                .build();
        return u.toString();
    }
}
