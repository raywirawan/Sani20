package com.nurina.sani20;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class ReminderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static EditText SeedName, ddStart, mmStart, yyStart, ddEnd, mmEnd, yyEnd;
    private static Button submit;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView homeRecyclerView;
//    private


    public ReminderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReminderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReminderFragment newInstance(String param1, String param2) {
        ReminderFragment fragment = new ReminderFragment();
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
        return inflater.inflate(R.layout.fragment_reminder, container, false);
    }
    @Override
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
                for (DataSnapshot reminderSnapshot : dataSnapshot.getChildren()) {
                    Padi padi = reminderSnapshot.getValue(Padi.class);
                    String name = padi.getNama();
                    String start = padi.getDateStart();
                    String end = padi.getDateEnd();
                    String id = padi.getId();
                    ///get days remaining count
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat myFormat = new SimpleDateFormat("d M yyyy");
                    String dateBeforeSt = start;
                    String dateAfterSt = end;
                    Date dateBefore = calendar.getTime();
                    Date dateAfter = calendar.getTime();
                    String dateRemaining = " ";
                    int dayProgress = 0;
                    try {
                        dateBefore = calendar.getTime();
                        dateAfter = myFormat.parse(dateAfterSt);
                        long difference = dateAfter.getTime() - dateBefore.getTime();
                        float daysBetween = (difference / (1000*60*60*24));
                        dayProgress = (int) daysBetween;
                        dateRemaining = String.valueOf(dayProgress)+" days remaining";
                    }catch (Exception e){
                        e.printStackTrace();
                        toast("date parsing error");
                    }
                    //get Total Day
                    Date dateBefore2 = calendar.getTime();
                    Date dateAfter2 = calendar.getTime();
                    int totaldays = 0;
                    try {
                        dateBefore2 = myFormat.parse(dateBeforeSt);
                        dateAfter2 = myFormat.parse(dateAfterSt);
                        long difference = dateAfter2.getTime() - dateBefore2.getTime();
                        float daysBetween = (difference / (1000*60*60*24));
                        totaldays = (int) daysBetween;
                    }catch (Exception e){
                        e.printStackTrace();
                        toast("date parsing error");
                    }
                    double progressRun = (totaldays - dayProgress);
                    double progressR = (progressRun / totaldays)*100.0;
                    int progress = (int) progressR;
                    padiArrayList.add(new Padi(id, name, start, end, dateRemaining, progress));
                }
                homeRecyclerView = view2.findViewById(R.id.recView);
                HomeAdapter homeAdapter = new HomeAdapter(padiArrayList, getContext());

                homeRecyclerView.setAdapter(homeAdapter);
                homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                toast("error getting data");
            }
        });
    }
    private View view2;
    private ArrayList<Padi> padiArrayList;
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SeedName = view.findViewById(R.id.insertSeedsName);
        ddStart = view.findViewById(R.id.dateReminder);
        mmStart = view.findViewById(R.id.monthReminder);
        yyStart = view.findViewById(R.id.yearReminder);
        ddEnd = view.findViewById(R.id.dateEndReminder);
        mmEnd = view.findViewById(R.id.monthEndReminder);
        yyEnd = view.findViewById(R.id.yearEndReminder);
        submit = view.findViewById(R.id.submitButtonDates);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitSeed();
            }
        });
        databaseReminder = FirebaseDatabase.getInstance().getReference("Reminder");
        mAuth = FirebaseAuth.getInstance();
        view2 = view;

    }
    DatabaseReference databaseReminder;
    private FirebaseAuth mAuth;
    private void submitSeed(){
        String  Seed = SeedName.getText().toString().trim(),
                dayStart = ddStart.getText().toString().trim(),
                monthStart = mmStart.getText().toString().trim(),
                yearStart = yyStart.getText().toString().trim(),
                dayEnd = ddEnd.getText().toString().trim(),
                monthEnd = mmEnd.getText().toString().trim(),
                yearEnd = yyEnd.getText().toString().trim();

        SimpleDateFormat myFormat = new SimpleDateFormat("d M yyyy");
        String dateStart = dayStart+" "+monthStart+" "+yearStart;
        String dateEnd = dayEnd+" "+monthEnd+" "+yearEnd;

        //VALIDATE INPUT
        if (!(TextUtils.isEmpty(Seed)||
                TextUtils.isEmpty(dayStart)||
                TextUtils.isEmpty(monthStart)||
                TextUtils.isEmpty(yearStart)||
                TextUtils.isEmpty(dayEnd)||
                TextUtils.isEmpty(monthEnd)||
                TextUtils.isEmpty(yearEnd))){

            String uid = mAuth.getCurrentUser().getUid();
            String id = databaseReminder.child(uid).push().getKey();
            Padi padi = new Padi(id, Seed,dateStart,dateEnd,"0",1);
            databaseReminder.child(uid).child(id).setValue(padi);
            toast("Data Submitted");
        } else {
           toast("please fill every text box");
        }
    }
    public void toast(String a) {
        Toast.makeText(getActivity(), a, Toast.LENGTH_SHORT).show();
    }
}
