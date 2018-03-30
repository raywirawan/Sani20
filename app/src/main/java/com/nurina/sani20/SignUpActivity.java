package com.nurina.sani20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {

    private Button buttonForHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        buttonForHome= findViewById(R.id.signUpButton);
        buttonForHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainActivity();
            }
        });


    }

    private void navigateToMainActivity(){
        Intent intent= new Intent (SignUpActivity.this,Home.class);
        startActivity(intent);
    }

}
