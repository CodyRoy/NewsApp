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
import com.example.cr554.newsapp.Util.APIKey;
import com.example.cr554.newsapp.Volley.VolleySingleton;
import com.example.cr554.newsapp.adapter.NewsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    //declare classwide vars
    RecyclerView newsList;
    TextView emptyView;
    public static List<NewsArticle> newsArticles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the views we'll be editing
        newsList =(RecyclerView)findViewById(R.id.newsList);
        emptyView = (TextView)findViewById(R.id.noNewsToShow);

        //call fetchnews() to fetch news
        fetchNews();
    }

    private void fetchNews(){
        //get the Json Request URL
        String url = getNewsUrl("sports");

        //** begin Json Request **//
        JsonObjectRequest moreNews = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
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
        //** end JSON Request **//

        //pass the JSON request to our volley singleton
        VolleySingleton.getInstance(this).addToRequestQueue(moreNews);
    }


    private String getNewsUrl(String topic){
        String baseUri = getString(R.string.baseuri);
        Uri u = Uri.parse(baseUri).buildUpon()
                .appendQueryParameter("show-fields","thumbnail") //makes the json return a thumbnail
                .appendQueryParameter("q",topic) // our actual search topic
                .appendQueryParameter("api-key", APIKey.FLICKER_API_KEY) //the api key
                .build();

        //u should equal:  http://content.guardianapis.com/search?show-fields=thumbnail&q=sports&api_key=e6678f97-7cd9-4156-88f7-f5f508c29ed3
        return u.toString();
    }
}
