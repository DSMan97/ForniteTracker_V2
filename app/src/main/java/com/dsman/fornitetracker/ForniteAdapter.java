package com.dsman.fornitetracker;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;

import java.util.HashMap;


public class ForniteAdapter extends RecyclerView.Adapter<JobsViewHolder> {


    //Creamos un objeto HashMap con nuestros elementos del usuario consultado (EpicUserScore)
    private HashMap<Integer,EpicUserScore> epicUserScoreHashMap;

    public ForniteAdapter(HashMap<Integer,EpicUserScore> epicUserScoreHashMap) {
        this.epicUserScoreHashMap = epicUserScoreHashMap;
    }


    //Se crea el viewholder

    public JobsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.recycleview_item, viewGroup, false);
        return new JobsViewHolder(view);
    }

    //Se pintan los cardView según los elementos recogidos en el HashMap
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull JobsViewHolder jobsViewHolder, int i) {
         EpicUserScore mItemS = epicUserScoreHashMap.get(i);
        jobsViewHolder.tvtCardTitle.setText(mItemS.getLabel());
        jobsViewHolder.tvtValueTitle.setText(mItemS.getDisplayValue());
        jobsViewHolder.tvtRankTitle.setText(R.string.rankin_title);
        jobsViewHolder.tvtValueRank.setText(mItemS.getRank());

    }

    //Devuelve el tamaño de la lista
    public int getItemCount() {
        return epicUserScoreHashMap.size();
    }
}






