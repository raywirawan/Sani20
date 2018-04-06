package com.nurina.sani20;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView homeRecyclerView;
    private TextView t0_forecast, t1_forecastLoc, t2_forecastTemp, t3_date;
    private ImageView currentWeatherImage;
    private String currentTime;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater infl = getActivity().getLayoutInflater();
        View view = infl.inflate(R.layout.fragment_blank, container, false);
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        if (hour >= 5 && hour < 18) {
            currentTime = "d";
        } else {
            currentTime = "n";
        }
        t0_forecast = view.findViewById(R.id.Weather);
        t1_forecastLoc = view.findViewById(R.id.location);
        t2_forecastTemp = view.findViewById(R.id.temperatureHome);
        t3_date = view.findViewById(R.id.date);
        currentWeatherImage = view.findViewById(R.id.weatherIconImageView);
        find_weather();
        return view;
    }

    public void find_weather(){
        String url = "http://api.openweathermap.org/data/2.5/weather?q="+ForecastFragment.setloc+",indonesia&appid=223d464cbbb322cb2b5077a6878d5611&units=metric";

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp = String.valueOf(main_object.getDouble("temp"));
                    String description = object.getString("main");
                    String city = response.getString("name");

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM YYYY");
                    String formattedDate = sdf.format(calendar.getTime());
                    double temp_int = Double.parseDouble(temp);
                    temp_int = Math.round(temp_int);
                    int c = (int) temp_int;
                    t0_forecast.setText(description);
                    t1_forecastLoc.setText(city+", Indonesia");
                    t2_forecastTemp.setText(String.valueOf(c)+"°");
                    t3_date.setText(formattedDate);

                    //GANTI ICON BERDASARKAN CUACA
                    if (description.equalsIgnoreCase("thunderstorm")){
                        currentWeatherImage.setImageResource(R.drawable.icn_storm);
                    } else if (description.equalsIgnoreCase("rain")||description.equalsIgnoreCase("drizzle")){
                        if (currentTime.equalsIgnoreCase("d")){
                            currentWeatherImage.setImageResource(R.drawable.icn_mornrain);
                        } else {
                            currentWeatherImage.setImageResource(R.drawable.icn_nightrain);
                        }
                    } else if (description.equalsIgnoreCase("clear")){
                        if (currentTime.equalsIgnoreCase("d")){
                            currentWeatherImage.setImageResource(R.drawable.icn_sunny);
                        } else {
                            currentWeatherImage.setImageResource(R.drawable.icn_night);
                        }
                    } else if (description.equalsIgnoreCase("clouds")){
                        if (currentTime.equalsIgnoreCase("d")){
                            currentWeatherImage.setImageResource(R.drawable.icn_morningcloudy);
                        } else {
                            currentWeatherImage.setImageResource(R.drawable.ic_weatherimage);
                        }
                    } else if (description.equalsIgnoreCase("extreme")){
                        currentWeatherImage.setImageResource(R.drawable.icn_storm);
                    } else {
                        if (currentTime.equalsIgnoreCase("d")){
                            currentWeatherImage.setImageResource(R.drawable.icn_sunny);
                        } else {
                            currentWeatherImage.setImageResource(R.drawable.icn_night);
                        }
                    }
                    toast("weather updated");

                }catch (JSONException e) {
                    e.printStackTrace();
                    toast("error updating data");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                toast("Error occured, please try again");
            }
        });
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(jor);
    }

    private ArrayList<Padi> padiArrayList;
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeRecyclerView = view.findViewById(R.id.recView);

        padiArrayList = new ArrayList<>();
        padiArrayList.add(new Padi("Rajalele", "0000", 1));
        padiArrayList.add(new Padi("Pandan Wangi", "01010", 2));
        padiArrayList.add(new Padi("Rajalele", "0000", 3));
        padiArrayList.add(new Padi("Pandan Wangi", "0000", 1));
        padiArrayList.add(new Padi("Rajalele", "00000", 2));
        padiArrayList.add(new Padi("Pandan Wangi", "00000", 3));
        padiArrayList.add(new Padi("Pandan Wangi", "00000", 1));
        padiArrayList.add(new Padi("Pandan Wangi", "0000", 2));
        padiArrayList.add(new Padi("Pandan Wangi", "00000", 3));

        HomeAdapter homeAdapter = new HomeAdapter(padiArrayList, getContext());

        homeRecyclerView.setAdapter(homeAdapter);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }
    public void toast(String a){
        Toast.makeText(getActivity(), a, Toast.LENGTH_SHORT).show();
    }

}
