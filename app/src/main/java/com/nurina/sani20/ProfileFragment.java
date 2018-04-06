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
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;



public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView profileRecyclerView;
    private TextView lokasi;
    private TextView username_Profile;
    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState)  {
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
        View view = infl.inflate(R.layout.fragment_profile, container, false);
        username_Profile = view.findViewById(R.id.usernameProfile);
        lokasi = view.findViewById(R.id.lokasiProfile);
        username_Profile.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        lokasi.setText(ForecastFragment.setloc);
        return view;
    }


    private ArrayList<ActivityHistory> ActivityHistoryArrayList;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profileRecyclerView = view.findViewById(R.id.recView);

        ActivityHistoryArrayList = new ArrayList<>();
        ActivityHistoryArrayList.add(new ActivityHistory("Yesterday", "Menanam padi jenis H-13", "Wednesday, 28 March 2018"));
        ActivityHistoryArrayList.add(new ActivityHistory("Yesterday", "Menanam padi jenis H-13", "Wednesday, 28 March 2018"));
        ActivityHistoryArrayList.add(new ActivityHistory("Yesterday", "Menanam padi jenis H-13", "Wednesday, 28 March 2018"));
                                ActivityHistoryArrayList.add(new ActivityHistory("Yesterday", "Menanam padi jenis H-13", "Wednesday, 28 March 2018"));

        ProfileAdapter profileAdapter = new ProfileAdapter(ActivityHistoryArrayList, getContext());

        profileRecyclerView.setAdapter(profileAdapter);
        profileRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }
}
