package com.example.c4q.meowfest.response;

import com.example.c4q.meowfest.models.CatImage;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatImageResponse {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;

    public List<CatImage> getCatImages() {
        return catImages;
    }

    public void setCatImages(List<CatImage> catImages) {
        this.catImages = catImages;
    }

    @SerializedName("catImageList")
    @Expose
    private List<CatImage> catImages = null;
}
