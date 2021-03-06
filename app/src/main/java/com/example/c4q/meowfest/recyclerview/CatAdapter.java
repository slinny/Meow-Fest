package com.example.c4q.meowfest.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.meowfest.R;
import com.example.c4q.meowfest.model.CatImage;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatViewHolder>{

    private List<CatImage> catImageList;

    public CatAdapter(List<CatImage> catImageList) {
        this.catImageList = catImageList;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemview_layout,viewGroup,false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder catViewHolder, int i) {
        catViewHolder.onBind(catImageList.get(i));
    }

    @Override
    public int getItemCount() {
        return catImageList.size();
    }
}
