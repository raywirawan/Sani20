package com.nurina.sani20;
import com.nurina.sani20.R;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class StartingPage extends AppCompatActivity {

    private Button buttonForLogIn;
    private Button buttonForSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_starting_page);
        buttonForLogIn= findViewById(R.id.LogInWithSani);
        buttonForLogIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                navigateToLogIn();
            }
        });

        buttonForSignUp=findViewById(R.id.CreateSaniAccount);
        buttonForSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSignUp();
            }
        });
    }

    private void navigateToLogIn(){
        Intent intent = new Intent(StartingPage.this, LogInActivity.class);
        startActivity(intent);
    }

    private void navigateToSignUp(){
        Intent intent = new Intent(StartingPage.this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_starting_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
