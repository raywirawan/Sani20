package com.nurina.sani20;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class seedTrackerAdapter extends RecyclerView.Adapter<seedTrackerAdapter.ViewHolder> {

    private ArrayList<Seed>seedArrayList ;
    private Context context;

    public seedTrackerAdapter(ArrayList<Seed> seedArrayList, Context context) {
        this.seedArrayList = seedArrayList;
        this.context = context;
}

    @NonNull
    @Override
    public seedTrackerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seed_tracker, parent, false);
        seedTrackerAdapter.ViewHolder vh = new seedTrackerAdapter.ViewHolder(mView);
        return vh;
    }

    public void onBindViewHolder(@NonNull seedTrackerAdapter.ViewHolder holder, int position) {

        Seed seed = seedArrayList.get(position);
        holder.padiType.setText(seed.getNama());
        holder.seedPrice.setText(seed.getHarga());
        holder.seedPerBerapa.setText("per kilogram");

    }
    public int getItemCount() {
        return seedArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView padiType;
        public TextView seedPrice;
        public TextView seedPerBerapa;

        public ViewHolder(View itemView) {
            super(itemView);
            padiType= itemView.findViewById(R.id.padiType);
            seedPrice = itemView.findViewById(R.id.seedPrice);
            seedPerBerapa= itemView.findViewById(R.id.seedPerBerapa);
        }
    }}


