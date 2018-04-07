package com.nurina.sani20;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class About extends AppCompatActivity {
    private ImageButton arrowBackAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar = getActionBar();
        arrowBackAbout= findViewById(R.id.arrowBackAbout);

        arrowBackAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSettings();
            }
        });



    }
    public void navigateToSettings(){
        Intent intent = new Intent(About.this, SettingsActivity.class);
        startActivity(intent);
    }
}
