package com.nurina.sani20;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;


    public class forecastAdapter extends RecyclerView.Adapter<com.nurina.sani20.forecastAdapter.ViewHolder> {

        private ArrayList<weeklyForecast> weeklyForecastsArrayList;
        private Context context;

        public forecastAdapter(ArrayList<weeklyForecast> weeklyForecastsArrayList, Context context) {
            this.weeklyForecastsArrayList = weeklyForecastsArrayList;
            this.context = context;
        }

        @NonNull
        @Override
        public forecastAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weekly_forecast, parent, false);
            forecastAdapter.ViewHolder vh = new ViewHolder(mView);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull forecastAdapter.ViewHolder holder, int position) {

            weeklyForecast weeklyForecast= weeklyForecastsArrayList.get(position);
            holder.weeklyForecastDay.setText(weeklyForecast.getDayWeeklyForecast());
            holder.weeklyForecastIcon.setImageResource(weeklyForecast.getIdIconWeeklyForecast());
            holder.weeklyForecastIcon.setId(weeklyForecast.getIdIconWeeklyForecast());
        }

        @Override
        public int getItemCount() {
            return weeklyForecastsArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView weeklyForecastIcon;
            public TextView weeklyForecastDay;


            public ViewHolder(View itemView) {
                super(itemView);
                weeklyForecastIcon= itemView.findViewById(R.id.weeklyForecastIcon);
                weeklyForecastDay=itemView.findViewById(R.id.weeklyForecastDay);
            }
        }
    }

