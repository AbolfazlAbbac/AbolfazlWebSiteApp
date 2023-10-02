package com.example.abolfazlwebsiteapp.Entity;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.List;

public class Posts {

    private int id;
    private String link;
    private String title;
    private String content;
    private List<String> _links;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }







}
