package com.nurina.sani20;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SliderIntro extends AppCompatActivity {

    private Button buttonForStart;
    private ViewPager viewPager;
    private SlideAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        startActivity(intent);
    }
}
