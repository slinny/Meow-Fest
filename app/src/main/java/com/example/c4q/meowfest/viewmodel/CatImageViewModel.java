package com.example.c4q.meowfest.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.c4q.meowfest.repositories.CatImageRepository;
import com.example.c4q.meowfest.response.CatImageResponse;

public class CatImageViewModel extends AndroidViewModel {

    private CatImageRepository catImageRepository;
    private LiveData<CatImageResponse> catImageResponseLiveData;


    public CatImageViewModel(@NonNull Application application) {
        super(application);

        catImageRepository = new CatImageRepository();
        this.catImageResponseLiveData = catImageRepository.getCatImagelist();
    }

    public LiveData<CatImageResponse> getCatImageResponseLiveData() {
        return catImageResponseLiveData;
    }
}
