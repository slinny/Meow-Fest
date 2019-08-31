package com.example.c4q.meowfest;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.c4q.meowfest.models.CatImage;
import com.example.c4q.meowfest.networking.CatService;
import com.example.c4q.meowfest.recyclerview.CatAdapter;
import com.example.c4q.meowfest.response.CatImageResponse;
import com.example.c4q.meowfest.viewmodel.CatImageViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView catRecyclerView;
    private CatService catService;
    private CatAdapter catAdapter;
    private List<CatImage> catImageList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    CatImageViewModel catImageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        getCatImageList();

    }

    private void initialization() {
        catRecyclerView = findViewById(R.id.recyclerview_cat);

        // use a linear layout manager
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        catRecyclerView.setLayoutManager(linearLayoutManager);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        catRecyclerView.setHasFixedSize(true);

        // adapter
        catAdapter = new CatAdapter(MainActivity.this,catImageList);
        catRecyclerView.setAdapter(catAdapter);

        // View Model
        catImageViewModel = ViewModelProviders.of(this).get(CatImageViewModel.class);
    }

    /**
     * get movies articles from news api
     *
     * @param @null
     */
    private void getCatImageList() {
        catImageViewModel.getCatImageResponseLiveData().observe(this, new Observer<CatImageResponse>() {
            @Override
            public void onChanged(@Nullable CatImageResponse catImageResponse) {
                if (catImageResponse != null) {
                    List<CatImage> catImages = catImageResponse.getCatImages();
                    catImageList.addAll(catImages);
                    catAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
