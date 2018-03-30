package com.nurina.sani20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LogInActivity extends AppCompatActivity {

    private Button buttonForHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        buttonForHome= findViewById(R.id.loginButton);
        buttonForHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMain();
            }
        });




    }
    private void navigateToMain(){
        Intent intent = new Intent(LogInActivity.this, Home.class);
        startActivity(intent);
    }

}
