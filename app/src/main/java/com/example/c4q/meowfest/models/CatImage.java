package com.example.c4q.meowfest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CatImage {

    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("image_url")
    private String imageUrl;
    @Expose
    @SerializedName("timestamp")
    private String timestamp;
    @Expose
    @SerializedName("title")
    private String title;

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTitle() {
        return title;
    }
}
