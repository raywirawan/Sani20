package com.nurina.sani20;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class SettingsActivity extends AppCompatActivity {
    private ImageButton arrowBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Settings");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ActionBar actionBar = getActionBar();



        arrowBack= findViewById(R.id.arrowBack);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHome();
            }
        });

        setTitle("Settings");

    }

    private void navigateToHome(){
        Intent intent = new Intent(SettingsActivity.this, Home.class);
        startActivity(intent);
    }

}
