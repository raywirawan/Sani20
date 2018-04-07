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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


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

    public void onStart() {
        super.onStart();
        String uid = mAuth.getCurrentUser().getUid();
        databaseReminder.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (padiArrayList != null) {
                    padiArrayList.clear();
                }
                padiArrayList = new ArrayList<>();
                ActivityHistoryArrayList = new ArrayList<>();
                for (DataSnapshot reminderSnapshot : dataSnapshot.getChildren()) {
                    Padi padi = reminderSnapshot.getValue(Padi.class);
                    String name = padi.getNama();
                    String start = padi.getDateStart();
                    String end = padi.getDateEnd();
                    String id = padi.getId();
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat format = new SimpleDateFormat("d M yyyy");
                    Date startdate = calendar.getTime();
                    try {
                        startdate = format.parse(start);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        toast("error parsing date");
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM YYYY");
                    String formattedDate = sdf.format(startdate);
                    String[] dateExtract = formattedDate.split(" ");
                    String dayName = dateExtract[0];
                    String compdate = dateExtract[1]+" "+dateExtract[2]+" "+dateExtract[3];
                    ActivityHistoryArrayList.add(new ActivityHistory(dayName, "Menanam padi jenis "+name, compdate));
                }
                profileRecyclerView = view2.findViewById(R.id.recView);
                ProfileAdapter profileAdapter = new ProfileAdapter(ActivityHistoryArrayList, getContext());

                profileRecyclerView.setAdapter(profileAdapter);
                profileRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                toast("error getting data");
            }
        });
    }
    DatabaseReference databaseReminder;
    private FirebaseAuth mAuth;
    private View view2;
    private ArrayList<Padi> padiArrayList;
    private ArrayList<ActivityHistory> ActivityHistoryArrayList;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        databaseReminder = FirebaseDatabase.getInstance().getReference("Reminder");
        mAuth = FirebaseAuth.getInstance();
        view2 = view;
    }

    public void toast(String a){
        Toast.makeText(getActivity(), a, Toast.LENGTH_SHORT).show();
    }
}
