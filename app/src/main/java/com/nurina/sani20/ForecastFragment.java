package com.nurina.sani20;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import java.util.Date;


public class ForecastFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView forecastRecyclerView;
    private Button getRandomTips;
    private String currentTime;
    public static String setloc = "Bogor";
    private TextView t0_forecast, t1_forecastLoc, t2_forecastTemp, t3_day, t4_date, t5_month, t6_year;
    private ImageView currentWeatherImage;
    private ConstraintLayout layoutForecast;
    private int image1 = R.drawable.ic_storm;
    private int image2 = R.drawable.ic_storm;
    private int image3 = R.drawable.ic_storm;
    private int image4 = R.drawable.ic_storm;
    private int image5 = R.drawable.ic_storm;
    private int image6 = R.drawable.ic_storm;
    private int image7 = R.drawable.ic_storm;
    public ForecastFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForecastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForecastFragment newInstance(String param1, String param2) {
        ForecastFragment fragment = new ForecastFragment();
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
        LayoutInflater infl = getActivity().getLayoutInflater();
        View view = infl.inflate(R.layout.fragment_forecast, container, false);

        layoutForecast = view.findViewById(R.id.layoutForecast);
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        if (hour >= 5 && hour < 18) {
            currentTime = "d";
            layoutForecast.setBackgroundResource(R.drawable.forecast_day);
        } else {
            currentTime = "n";
            layoutForecast.setBackgroundResource(R.drawable.forecast_night);
        }
        currentWeatherImage = view.findViewById(R.id.weatherImageForecast);
        t0_forecast = view.findViewById(R.id.weatherForecast);
        t1_forecastLoc = view.findViewById(R.id.forecastLocation);
        t2_forecastTemp = view.findViewById(R.id.tempForecast);
        t3_day = view.findViewById(R.id.dayForecast);
        t4_date = view.findViewById(R.id.dateForecast);
        t5_month = view.findViewById(R.id.monthForecast);
        t6_year = view.findViewById(R.id.yearForecast);
        return view;
    }
    public void find_weatherDaily(final View view){
        String url2 = "http://api.openweathermap.org/data/2.5/forecast/daily?q="+setloc+",ID&appid=3805dd8eda02a9e61920a575cd81b269";
        JsonObjectRequest jor2 = new JsonObjectRequest(Request.Method.GET, url2, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray list = response.getJSONArray("list");
                    JSONArray hari = response.getJSONArray("list");
                        JSONObject hari1 = hari.getJSONObject(0);
                            JSONArray cuaca1 = hari1.getJSONArray("weather");
                            JSONObject cuacaHari1 = cuaca1.getJSONObject(0);
                            String weather1 = cuacaHari1.getString("main");
                        JSONObject hari2 = hari.getJSONObject(1);
                            JSONArray cuaca2 = hari2.getJSONArray("weather");
                            JSONObject cuacaHari2 = cuaca2.getJSONObject(0);
                            String weather2 = cuacaHari2.getString("main");
                        JSONObject hari3 = hari.getJSONObject(2);
                            JSONArray cuaca3 = hari3.getJSONArray("weather");
                            JSONObject cuacaHari3 = cuaca3.getJSONObject(0);
                            String weather3 = cuacaHari3.getString("main");
                        JSONObject hari4 = hari.getJSONObject(3);
                            JSONArray cuaca4 = hari4.getJSONArray("weather");
                            JSONObject cuacaHari4 = cuaca4.getJSONObject(0);
                            String weather4 = cuacaHari4.getString("main");
                        JSONObject hari5 = hari.getJSONObject(4);
                            JSONArray cuaca5 = hari5.getJSONArray("weather");
                            JSONObject cuacaHari5 = cuaca5.getJSONObject(0);
                            String weather5 = cuacaHari5.getString("main");
                        JSONObject hari6 = hari.getJSONObject(5);
                            JSONArray cuaca6 = hari6.getJSONArray("weather");
                            JSONObject cuacaHari6 = cuaca6.getJSONObject(0);
                            String weather6 = cuacaHari6.getString("main");
                        JSONObject hari7 = hari.getJSONObject(6);
                            JSONArray cuaca7 = hari7.getJSONArray("weather");
                            JSONObject cuacaHari7 = cuaca7.getJSONObject(0);
                            String weather7 = cuacaHari7.getString("main");

                    //set icon hari 1
                    if (weather1.equalsIgnoreCase("thunderstorm")){
                        image1 = R.drawable.icn_storm;
                    } else if (weather1.equalsIgnoreCase("rain")||weather1.equalsIgnoreCase("drizzle")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image1 = R.drawable.icn_mornrain;
                        } else {
                            image1 = R.drawable.icn_nightrain;                        }
                    } else if (weather1.equalsIgnoreCase("clear")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image1 = R.drawable.icn_sunny;
                        } else {
                            image1 = R.drawable.icn_night;
                        }
                    } else if (weather1.equalsIgnoreCase("clouds")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image1 = R.drawable.icn_morningcloudy;
                        } else {
                            image1 = R.drawable.ic_weatherimage;
                        }
                    } else if (weather1.equalsIgnoreCase("extreme")){
                        image1 = R.drawable.icn_storm;
                    } else {
                        if (currentTime.equalsIgnoreCase("d")){
                            image1 = R.drawable.icn_sunny;
                        } else {
                            image1 = R.drawable.icn_night;
                        }
                    }

                    //set icon hari 2
                    if (weather2.equalsIgnoreCase("thunderstorm")){
                        image2 = R.drawable.icn_storm;
                    } else if (weather2.equalsIgnoreCase("rain")||weather2.equalsIgnoreCase("drizzle")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image2 = R.drawable.icn_mornrain;
                        } else {
                            image2 = R.drawable.icn_nightrain;
                        }
                    } else if (weather2.equalsIgnoreCase("clear")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image2 = R.drawable.icn_sunny;
                        } else {
                            image2 = R.drawable.icn_night;
                        }
                    } else if (weather2.equalsIgnoreCase("clouds")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image2 = R.drawable.icn_morningcloudy;
                        } else {
                            image2 = R.drawable.ic_weatherimage;
                        }
                    } else if (weather2.equalsIgnoreCase("extreme")){
                        image2 = R.drawable.icn_storm;
                    } else {
                        if (currentTime.equalsIgnoreCase("d")){
                            image2 = R.drawable.icn_sunny;
                        } else {
                            image2 = R.drawable.icn_night;
                        }
                    }

                    //set icon hari 3
                    if (weather3.equalsIgnoreCase("thunderstorm")){
                        image3 = R.drawable.icn_storm;
                    } else if (weather3.equalsIgnoreCase("rain")||weather3.equalsIgnoreCase("drizzle")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image3 = R.drawable.icn_mornrain;
                        } else {
                            image3 = R.drawable.icn_nightrain;
                        }
                    } else if (weather3.equalsIgnoreCase("clear")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image3 = R.drawable.icn_sunny;
                        } else {
                            image3 = R.drawable.icn_night;
                        }
                    } else if (weather3.equalsIgnoreCase("clouds")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image3 = R.drawable.icn_morningcloudy;
                        } else {
                            image3 = R.drawable.ic_weatherimage;
                        }
                    } else if (weather3.equalsIgnoreCase("extreme")){
                        image3 = R.drawable.icn_storm;
                    } else {
                        if (currentTime.equalsIgnoreCase("d")){
                            image3 = R.drawable.icn_sunny;
                        } else {
                            image3 = R.drawable.icn_night;
                        }
                    }

                    //set icon hari 4
                    if (weather4.equalsIgnoreCase("thunderstorm")){
                        image4 = R.drawable.icn_storm;
                    } else if (weather4.equalsIgnoreCase("rain")||weather4.equalsIgnoreCase("drizzle")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image4 = R.drawable.icn_mornrain;
                        } else {
                            image4 = R.drawable.icn_nightrain;
                        }
                    } else if (weather4.equalsIgnoreCase("clear")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image4 = R.drawable.icn_sunny;
                        } else {
                            image4 = R.drawable.icn_night;
                        }
                    } else if (weather4.equalsIgnoreCase("clouds")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image4 = R.drawable.icn_morningcloudy;
                        } else {
                            image4 = R.drawable.ic_weatherimage;
                        }
                    } else if (weather4.equalsIgnoreCase("extreme")){
                        image4 = R.drawable.icn_storm;
                    } else {
                        if (currentTime.equalsIgnoreCase("d")){
                            image4 = R.drawable.icn_sunny;
                        } else {
                            image4 = R.drawable.icn_night;
                        }
                    }

                    //set icon hari5
                    if (weather5.equalsIgnoreCase("thunderstorm")){
                        image5 = R.drawable.icn_storm;
                    } else if (weather5.equalsIgnoreCase("rain")||weather5.equalsIgnoreCase("drizzle")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image5 = R.drawable.icn_mornrain;
                        } else {
                            image5 = R.drawable.icn_nightrain;
                        }
                    } else if (weather5.equalsIgnoreCase("clear")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image5 = R.drawable.icn_sunny;
                        } else {
                            image5 = R.drawable.icn_night;
                        }
                    } else if (weather5.equalsIgnoreCase("clouds")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image5 = R.drawable.icn_morningcloudy;
                        } else {
                            image5 = R.drawable.ic_weatherimage;
                        }
                    } else if (weather5.equalsIgnoreCase("extreme")){
                        image5 = R.drawable.icn_storm;
                    } else {
                        if (currentTime.equalsIgnoreCase("d")){
                            image5 = R.drawable.icn_sunny;
                        } else {
                            image5 = R.drawable.icn_night;
                        }
                    }

                    //set icon hari 6
                    if (weather6.equalsIgnoreCase("thunderstorm")){
                        image6 = R.drawable.icn_storm;
                    } else if (weather6.equalsIgnoreCase("rain")||weather6.equalsIgnoreCase("drizzle")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image6 = R.drawable.icn_mornrain;
                        } else {
                            image6 = R.drawable.icn_nightrain;
                        }
                    } else if (weather6.equalsIgnoreCase("clear")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image6 = R.drawable.icn_sunny;
                        } else {
                            image6 = R.drawable.icn_night;
                        }
                    } else if (weather6.equalsIgnoreCase("clouds")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image6 = R.drawable.icn_morningcloudy;
                        } else {
                            image6 = R.drawable.ic_weatherimage;
                        }
                    } else if (weather6.equalsIgnoreCase("extreme")){
                        image6 = R.drawable.icn_storm;
                    } else {
                        if (currentTime.equalsIgnoreCase("d")){
                            image6 = R.drawable.icn_sunny;
                        } else {
                            image6 = R.drawable.icn_night;
                        }
                    }

                    //set icon hari7
                    if (weather7.equalsIgnoreCase("thunderstorm")){
                        image7 = R.drawable.icn_storm;
                    } else if (weather7.equalsIgnoreCase("rain")||weather7.equalsIgnoreCase("drizzle")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image7 = R.drawable.icn_mornrain;
                        } else {
                            image7 = R.drawable.icn_nightrain;
                        }
                    } else if (weather7.equalsIgnoreCase("clear")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image7 = R.drawable.icn_sunny;
                        } else {
                            image7 = R.drawable.icn_night;
                        }
                    } else if (weather7.equalsIgnoreCase("clouds")){
                        if (currentTime.equalsIgnoreCase("d")){
                            image7 = R.drawable.icn_morningcloudy;
                        } else {
                            image7 = R.drawable.ic_weatherimage;
                        }
                    } else if (weather7.equalsIgnoreCase("extreme")){
                        image7 = R.drawable.icn_storm;
                    } else {
                        if (currentTime.equalsIgnoreCase("d")){
                            image7 = R.drawable.icn_sunny;
                        } else {
                            image7 = R.drawable.icn_night;
                        }
                    }
                    toast("daily weather updated");

                    forecastRecyclerView = view.findViewById(R.id.recViewWeeklyForecast);

                    weeklyForecastArrayList= new ArrayList<>();

                    weeklyForecastArrayList.add(new weeklyForecast(image1,"Today"));
                    weeklyForecastArrayList.add(new weeklyForecast(image2,"Sunday"));
                    weeklyForecastArrayList.add(new weeklyForecast(image3,"Monday"));
                    weeklyForecastArrayList.add(new weeklyForecast(image4,"Tuesday"));
                    weeklyForecastArrayList.add(new weeklyForecast(image5,"Wednesday"));
                    weeklyForecastArrayList.add(new weeklyForecast(image6,"Thursday"));
                    weeklyForecastArrayList.add(new weeklyForecast(image7,"Friday"));

                    forecastAdapter forecastAdapter = new forecastAdapter(weeklyForecastArrayList, getContext());


                    forecastRecyclerView.setAdapter(forecastAdapter);
                    forecastRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                } catch (JSONException er){
                    er.printStackTrace();
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
        queue.add(jor2);
    }

    public void find_weather() {
        String url = "http://api.openweathermap.org/data/2.5/weather?q="+setloc+",indonesia&appid=223d464cbbb322cb2b5077a6878d5611&units=metric";

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
                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE,dd,MMMM,YYYY");
                    String formattedDate = sdf.format(calendar.getTime());
                    String[] split_date = formattedDate.split(",");
                    String  day = split_date[0],
                            date = split_date[1],
                            month = split_date[2],
                            year = split_date[3];
                    double temp_int = Double.parseDouble(temp);
                    temp_int = Math.round(temp_int);
                    int c = (int) temp_int;
                    t0_forecast.setText(description);
                    t1_forecastLoc.setText(city+", Indonesia");
                    t2_forecastTemp.setText(String.valueOf(c)+"°");
                    t3_day.setText(day);
                    t4_date.setText(date);
                    t5_month.setText(month);
                    t6_year.setText(year);

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

    private ArrayList<weeklyForecast> weeklyForecastArrayList;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        find_weatherDaily(view);
        find_weather();
        getRandomTips= view.findViewById(R.id.getRandomTips);
        getRandomTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                popUpSanisTipsDialog popUpSanisTipsDialog= com.nurina.sani20.popUpSanisTipsDialog.newInstance();
                popUpSanisTipsDialog.show(fm,"pop up tips");
               // showTipsDialog();
            }
        });


//        forecastRecyclerView = view.findViewById(R.id.recViewWeeklyForecast);
//
//        weeklyForecastArrayList= new ArrayList<>();
//
//        weeklyForecastArrayList.add(new weeklyForecast(image1,"Today"));
//        weeklyForecastArrayList.add(new weeklyForecast(image2,"Sunday"));
//        weeklyForecastArrayList.add(new weeklyForecast(image3,"Monday"));
//        weeklyForecastArrayList.add(new weeklyForecast(image4,"Tuesday"));
//        weeklyForecastArrayList.add(new weeklyForecast(image5,"Wednesday"));
//        weeklyForecastArrayList.add(new weeklyForecast(image6,"Thursday"));
//        weeklyForecastArrayList.add(new weeklyForecast(image7,"Friday"));
//
//        forecastAdapter forecastAdapter = new forecastAdapter(weeklyForecastArrayList, getContext());
//
//
//        forecastRecyclerView.setAdapter(forecastAdapter);
//        forecastRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private TextView tipsTextView;

    private void showTipsDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogview = inflater.inflate(R.layout.dialog, null);
        alertDialog.setContentView(dialogview);
//        tipsTextView = dialogview.find
        alertDialog.show();

    }
    public void toast(String a){
        Toast.makeText(getActivity(), a, Toast.LENGTH_SHORT).show();
    }


}
