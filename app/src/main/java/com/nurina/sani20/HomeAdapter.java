package com.nurina.sani20;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<Padi> padiArrayList;
    private Context context;

    public HomeAdapter(ArrayList<Padi> padiArrayList, Context context) {
        this.padiArrayList = padiArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_padi, parent, false);
        ViewHolder vh = new ViewHolder(mView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Padi padi = padiArrayList.get(position);
        holder.namaPadiTextView.setText(padi.getNama());
        holder.tipePadiTextView.setText(padi.getTipe());
        holder.progressBar.setProgress(padi.getNilai());

    }

    @Override
    public int getItemCount() {
        return padiArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView namaPadiTextView;
        public TextView tipePadiTextView;
        public ProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);
            progressBar= itemView.findViewById(R.id.progressBar);
            namaPadiTextView = itemView.findViewById(R.id.namaPadiTextView);
            tipePadiTextView= itemView.findViewById(R.id.tipePadiTextView);
        }
    }

}
