package com.nurina.sani20;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class riceTrackerAdapter extends RecyclerView.Adapter<com.nurina.sani20.riceTrackerAdapter.ViewHolder>{

        private ArrayList<rice> riceArrayList ;
        private Context context;

        public riceTrackerAdapter(ArrayList<rice> riceArrayList, Context context) {
            this.riceArrayList = riceArrayList;
            this.context = context;
        }

        @NonNull
        @Override
        public com.nurina.sani20.riceTrackerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rice_tracker, parent, false);
            com.nurina.sani20.riceTrackerAdapter.ViewHolder vh = new com.nurina.sani20.riceTrackerAdapter.ViewHolder(mView);
            return vh;
        }

        public void onBindViewHolder(@NonNull com.nurina.sani20.riceTrackerAdapter.ViewHolder holder, int position) {


            rice Rice = riceArrayList.get(position);
            holder.riceType.setText(Rice.getRiceType());
            holder.ricePrice.setText(Integer.toString(Rice.getRicePrice()));
            holder.ricePerBerapa.setText("per kilogram");
            holder.naikturunHarga.setImageResource(Rice.getIdIconHarga());

        }
        public int getItemCount() {
            return riceArrayList.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView riceType;
            public TextView ricePrice;
            public TextView ricePerBerapa;
            public ImageView naikturunHarga;

            public ViewHolder(View itemView) {
                super(itemView);
                riceType= itemView.findViewById(R.id.riceType);
                ricePrice = itemView.findViewById(R.id.ricePrice);
                ricePerBerapa= itemView.findViewById(R.id.ricePerBerapa);
                naikturunHarga = itemView.findViewById(R.id.triangleParameterRice);
            }
        }


}
