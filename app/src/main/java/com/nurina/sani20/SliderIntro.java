package com.nurina.sani20;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SliderIntro extends AppCompatActivity {

    private Button buttonForStart;
    private ViewPager viewPager;
    private SlideAdapter myadapter;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            navigateToStart();
        }
        if (FirebaseAuth.getInstance().getCurrentUser() != null){
            navigateToHome();
        }
        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_slider_intro);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);
        buttonForStart= findViewById(R.id.sliderbutton);
        buttonForStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                navigateToStart();
            }
        });
    }
    public void navigateToStart() {
        Intent intent = new Intent(SliderIntro.this, StartingPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    public void navigateToHome() {
        Intent intent = new Intent(SliderIntro.this, Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
