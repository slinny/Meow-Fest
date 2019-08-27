package com.example.c4q.meowfest.networking;

import com.example.c4q.meowfest.models.CatImage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatService {
    @GET("/api/cats?page=0")
    Call<List<CatImage>> getCatImageList();
}
