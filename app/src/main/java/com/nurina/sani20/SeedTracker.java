package com.nurina.sani20;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link SeedTracker#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeedTracker extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView SeedTrackerRecyclerView;



    public SeedTracker() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeedTracker.
     */
    // TODO: Rename and change types and number of parameters
    public static SeedTracker newInstance(String param1, String param2) {
        SeedTracker fragment = new SeedTracker();
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
        return inflater.inflate(R.layout.fragment_seed_tracker, container, false);
    }

    private ArrayList<Seed> seedArrayList;
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SeedTrackerRecyclerView = view.findViewById(R.id.recView);
        seedArrayList=new ArrayList<>();
        seedArrayList.add(new Seed("Rojolele",10000, "per 5 kilogram"));
        seedArrayList.add(new Seed("Rojolele",10000, "per 5 kilogram"));
        seedArrayList.add(new Seed("Rojolele",10000, "per 5 kilogram"));
        seedArrayList.add(new Seed("Rojolele",10000, "per 5 kilogram"));
        seedArrayList.add(new Seed("Rojolele",10000, "per 5 kilogram"));

        seedTrackerAdapter SeedTrackerAdapter = new seedTrackerAdapter(seedArrayList, getContext());

        SeedTrackerRecyclerView.setAdapter(SeedTrackerAdapter);
        SeedTrackerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }
}
