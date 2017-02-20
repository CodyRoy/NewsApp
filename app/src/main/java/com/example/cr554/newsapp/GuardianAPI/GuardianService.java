package com.example.cr554.newsapp.GuardianAPI;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by cr554 on 2/20/2017.
 */

public class GuardianService {
    public static final String API_BASE_URL = "http://content.guardianapis.com/";
    RequestQueue queue = Volley.newRequestQueue(this);
}
