package com.example.c4q.meowfest.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c4q.meowfest.R;
import com.example.c4q.meowfest.model.CatImage;
import com.squareup.picasso.Picasso;

public class CatViewHolder extends RecyclerView.ViewHolder {

    private CardView catCardView;
    private ImageView catImage;
    private TextView catTitle;
    private TextView catDescription;
    private TextView catTime;
    private String catImageUrl;

    public CatViewHolder(@NonNull View itemView) {
        super(itemView);
        catCardView = itemView.findViewById(R.id.cat_cardview);
        catImage = itemView.findViewById(R.id.itemview_image);
        catTitle = itemView.findViewById(R.id.title_textview);
        catDescription = itemView.findViewById(R.id.description_textview);
        catTime = itemView.findViewById(R.id.time_textview);
    }

    public void onBind(CatImage response) {
        Picasso.get().load(response.getImageUrl()).into(catImage);
        catTitle.setText(response.getTitle());
        catDescription.setText(response.getDescription());
        catImageUrl = response.getImageUrl();
        catTime.setText(response.getTimestamp());
    }
}
