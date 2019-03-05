package com.example.c4q.meowfest.networking;

public class RetrofitCall {
    private static final String BASE_URL = "https://chex-triplebyte.herokuapp.com/";

    public static CatService getCatImageList() {
        return RetrofitClient.getRetrofitClient(BASE_URL).create(CatService.class);
    }
}
