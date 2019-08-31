package com.example.c4q.meowfest.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.c4q.meowfest.networking.CatService;
import com.example.c4q.meowfest.networking.RetrofitCall;
import com.example.c4q.meowfest.response.CatImageResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatImageRepository {
    private CatService catService;

    public CatImageRepository() {
        catService = RetrofitCall.getCatImageList();
    }

    public LiveData<CatImageResponse> getCatImagelist() {
        final MutableLiveData<CatImageResponse> data = new MutableLiveData<>();
        catService.getCatImageList()
                .enqueue(new Callback<CatImageResponse>() {

                    @Override
                    public void onResponse(Call<CatImageResponse> call, Response<CatImageResponse> response) {

                        Log.d("CAP", "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<CatImageResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
