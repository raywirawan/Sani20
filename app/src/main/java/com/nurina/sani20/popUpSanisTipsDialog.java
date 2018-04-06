package com.nurina.sani20;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class popUpSanisTipsDialog extends DialogFragment{
    private Button getMoreRandomTips;
    private Button thankyou;
    private ImageButton exitDialog;

    public popUpSanisTipsDialog() {

    }

    public static popUpSanisTipsDialog newInstance(){
        return new popUpSanisTipsDialog();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pop_up_tips, container,
                false);
        getDialog().setTitle("DialogFragment Tutorial");
        // Do something else
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getMoreRandomTips= view.findViewById(R.id.getMoreRandomTips);
        getMoreRandomTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                popUpSanisTipsDialog popUpSanisTipsDialog= com.nurina.sani20.popUpSanisTipsDialog.newInstance();
                popUpSanisTipsDialog.show(fm,"pop up tips");;
            }
        });

        thankyou= view.findViewById(R.id.ThankYou);
        thankyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

            }
        });

        exitDialog=view.findViewById(R.id.exitDialog);
        exitDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {

        super.onResume();
        Window window = getDialog().getWindow();
        Point size = new Point();

        Display display = window.getWindowManager().getDefaultDisplay();

        display.getSize(size);

        window.setLayout((int) (size.x* 1.0),(int)(size.y*0.5));


        window.setGravity(Gravity.BOTTOM);

    }
}
