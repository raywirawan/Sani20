package com.nurina.sani20;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.TextView;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private ArrayList<ActivityHistory> ActivityHistoryArrayList;
    private Context context;

    public ProfileAdapter(ArrayList<ActivityHistory> ActivityHistoryArrayList, Context context) {
        this.ActivityHistoryArrayList = ActivityHistoryArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity_history, parent, false);
//        ViewHolder vh = new ViewHolder(mView);
//        return vh;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_activity_history, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ActivityHistory activity_History = ActivityHistoryArrayList.get(position);
        holder.penandaHari.setText(activity_History.getPenandaHari());
        holder.aktivitasPetani.setText(activity_History.getAktivitas());
        holder.historyDate.setText(activity_History.getWaktu());

    }

    @Override
    public int getItemCount() {
        return ActivityHistoryArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView penandaHari;
        public TextView aktivitasPetani;
        public TextView historyDate;

        public ViewHolder(View itemView) {
            super(itemView);
            penandaHari= itemView.findViewById(R.id.penandaHari);
            aktivitasPetani = itemView.findViewById(R.id.aktivitasPetani);
            historyDate= itemView.findViewById(R.id.historyDate);
        }
    }

}
