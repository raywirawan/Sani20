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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class riceTracker extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView riceTrackerRecyclerView;

    public riceTracker() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment riceTracker.
     */
    // TODO: Rename and change types and number of parameters
    public static riceTracker newInstance(String param1, String param2) {
        riceTracker fragment = new riceTracker();
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
        return inflater.inflate(R.layout.fragment_rice_tracker, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        databaseHargaBeras.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (riceArrayList != null) {
                    riceArrayList.clear();
                }

                riceArrayList=new ArrayList<>();
                for (DataSnapshot riceSnapshot : dataSnapshot.getChildren()){
                    rice Rice = riceSnapshot.getValue(rice.class);
                    riceArrayList.add(Rice);
                }
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
                String formattedTime = sdf.format(calendar.getTime());
                dateRefresh = view2.findViewById(R.id.dateLastUpdatedRice);
                dateRefresh.setText(formattedTime);
                riceTrackerRecyclerView = view2.findViewById(R.id.recViewRice);
                riceTrackerAdapter riceTrackerAdapter = new riceTrackerAdapter(riceArrayList, getContext());
                riceTrackerRecyclerView.setAdapter(riceTrackerAdapter);
                riceTrackerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                toast("error getting data");
            }
        });
    }
    private TextView dateRefresh;
    DatabaseReference databaseHargaBeras;
    private View view2;
    private ArrayList<rice> riceArrayList;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        databaseHargaBeras = FirebaseDatabase.getInstance().getReference("HargaBeras");
        view2 = view;

    }
    public void toast(String a){
        Toast.makeText(getActivity(), a, Toast.LENGTH_SHORT).show();
    }
}
