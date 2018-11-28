package com.dsman.fornitetracker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

//Inicializamos los TextView de la vista "Recycleview_item"

public class JobsViewHolder extends RecyclerView.ViewHolder {

    public TextView tvtCardTitle, tvtValueTitle, tvtValueRank, tvtRankTitle;

    public JobsViewHolder(View mItemView) {
        super(mItemView);
        tvtCardTitle = mItemView.findViewById(R.id.tvtTittle);
        tvtValueTitle = mItemView.findViewById(R.id.tvtValue);
        tvtRankTitle = mItemView.findViewById(R.id.tvtRankTitle);
        tvtValueRank = mItemView.findViewById(R.id.tvtRank);
    }
}

