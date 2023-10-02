package com.example.abolfazlwebsiteapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.abolfazlwebsiteapp.Entity.Posts;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ApiService {
    private final String MAIN_URL = "https://abolfazlabbasi.top/wp-json/wp/v2/posts/";
    private Gson gson;
    private static RequestQueue requestQueue;

    public ApiService(Context context) {
        gson = new Gson();
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public void getPosts() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                MAIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                List<Posts> postsList = new ArrayList<>();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        //Change the whole jsonArray to one json object Post
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Posts posts = new Posts();
                        posts.setId(jsonObject.getInt("id"));
                        posts.setLink(jsonObject.getString("link"));
                        posts.setTitle(jsonObject.getString("title"));

                        //Get Title
                        JSONObject jsonObjectTitle = jsonObject.getJSONObject("title");
                        posts.setTitle(jsonObjectTitle.getString("rendered"));

                        //Get Description
                        JSONObject jsonObjectDescription= jsonObject.getJSONObject("content");
                        posts.setContent(jsonObjectDescription.getString("rendered"));

                        postsList.add(posts);
                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


                Log.i("GetPosts", "onResponse: " + postsList.get(0).getContent());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("GetPosts", "onErrorResponse: " + error.getMessage());
            }
        });

        requestQueue.add(stringRequest);
    }

    interface CallBack {
        void onSuccess(List<Posts> posts);
    }

}
