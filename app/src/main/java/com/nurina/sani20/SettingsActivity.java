package com.nurina.sani20;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class SettingsActivity extends AppCompatActivity {
    private ImageButton arrowBack;
    private Button AboutButton;
    private EditText editLocation;
    private Button changeButton;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Settings");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ActionBar actionBar = getActionBar();

        editLocation =  findViewById(R.id.changeLocationInput);
        changeButton = findViewById(R.id.changeButton);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    changeLocation();
            }
        });
        arrowBack= findViewById(R.id.arrowBack);
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHome();
            }
        });

        setTitle("Settings");

        AboutButton=findViewById(R.id.AboutButton);

        AboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToAbout();
            }
        });

    }

    private void changeLocation(){
        String newLocation = editLocation.getText().toString().trim();
        if (newLocation.isEmpty()){
            editLocation.setError("Enter a Location");
            editLocation.requestFocus();
        }else {
            ForecastFragment.setloc = newLocation;
            toast("Location Changed successfully");
        }
    }

    private void navigateToHome(){
        Intent intent = new Intent(SettingsActivity.this, Home.class);
        startActivity(intent);
    }

    private void navigateToAbout(){
        Intent intent = new Intent(SettingsActivity.this, About.class);
        startActivity(intent);

    }
    public void toast(String a) {
        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
    }

}
