package com.dsman.fornitetracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.annotation.NonNull;

import java.util.List;


public class ForniteAdapter extends RecyclerView.Adapter<ForniteAdapter.JobsViewHolder> {


    //Creamos una lista con nnuestros elementos del usuario consultado
    private List<EpicUserData> dataObject;

    public ForniteAdapter(List<EpicUserData> dataObject) {
        this.dataObject = dataObject;
    }

    //Se crea el viewholder
    @Override
    public JobsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.recycleview_item, viewGroup, false);
        return new JobsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(JobsViewHolder jobsViewHolder, int i) {
        final EpicUserData item = dataObject.get(i);
        jobsViewHolder.mCardTitle.setText(item.getLabel());
        jobsViewHolder.mValueTitle.setText(item.getDisplayValue());
        jobsViewHolder.tvtValueRank.setText(item.getRank());

    }

    //Se pintan los cardView
    @Override
    public int getItemCount() {
        return dataObject.size();
    }

    public class JobsViewHolder extends RecyclerView.ViewHolder {

        private TextView mCardTitle, mValueTitle, tvtValueRank;

        public JobsViewHolder(View itemView) {
            super(itemView);
            mCardTitle = itemView.findViewById(R.id.tvtTittle);
            mValueTitle = itemView.findViewById(R.id.tvtValue);
            tvtValueRank = itemView.findViewById(R.id.tvtRank);
        }
    }
}