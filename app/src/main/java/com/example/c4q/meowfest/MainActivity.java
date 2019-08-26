package com.example.c4q.meowfest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.c4q.meowfest.model.CatImage;
import com.example.c4q.meowfest.networking.CatService;
import com.example.c4q.meowfest.networking.RetrofitCall;
import com.example.c4q.meowfest.recyclerview.CatAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView catRecyclerView;
    private CatService catService;
    private CatAdapter catAdapter;
    private List<CatImage> catImageList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catRecyclerView = findViewById(R.id.recyclerview_cat);
        catService = RetrofitCall.getCatImageList();

        catService.getCatImageList().enqueue(new Callback<List<CatImage>>() {
            @Override
            public void onResponse(Call<List<CatImage>> call, Response<List<CatImage>> response) {
                catImageList= response.body();
                Log.d("retrofit response", catImageList.toString());
                catAdapter = new CatAdapter(catImageList);
                catRecyclerView.setAdapter(catAdapter);
            }

            @Override
            public void onFailure(Call<List<CatImage>> call, Throwable t) {
                t.printStackTrace();
            }
        });

//        catAdapter = new CatAdapter(catImageList);
//        catRecyclerView.setAdapter(catAdapter);

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        catRecyclerView.setLayoutManager(linearLayoutManager);

    }
}
