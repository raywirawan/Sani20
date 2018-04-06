package com.nurina.sani20;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;
import com.google.firebase.auth.FirebaseAuth;

import static com.nurina.sani20.BlankFragment.newInstance;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inHome = true;
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = ((NavigationView) findViewById(R.id.nav_view)).getHeaderView(0);
        TextView CurrentUsername = (header.findViewById(R.id.currentuser_id));
        CurrentUsername.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        displayFragment(newInstance("", ""));
        setTitle("Home");

    }
    private Boolean exit = false;
    public Boolean inHome = true;
    @Override
    public void onBackPressed() {
       if (inHome){
            if (exit) {
                this.finishAffinity(); // finish activity
            } else {
                toast("Press Back again to Exit");
                exit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 3 * 1000);
            }
        }else {
            navigateToHome();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
       int id = item.getItemId();
        Fragment fragment = null;
        switch (id) {
            default:
            case R.id.nav_home:
                fragment = BlankFragment.newInstance("", "");
                setTitle("Home");
                inHome = false;
                break;
            case R.id.nav_profile:
                fragment= ProfileFragment.newInstance("", "");
                setTitle("Profile");
                inHome = false;
                break;
            case R.id.nav_check_seed_price:
                fragment= SeedTracker.newInstance("", "");
                setTitle("Price Tracker");
                inHome = false;
                break;
            case R.id.nav_check_rice_price:
                fragment=riceTracker.newInstance("", "");
                setTitle("Price Tracker");
                inHome = false;
                break;
            case R.id.nav_reminder:
                fragment=ReminderFragment.newInstance("", "");
                setTitle("Reminder");
                inHome = false;
                break;
            case R.id.nav_forecast:
                fragment=ForecastFragment.newInstance("", "");
                setTitle("Forecast");
                inHome = false;
                break;
            case R.id.nav_settings:
                navigateToSettings();
                inHome = false;
                break;
            case R.id.nav_quit:
                FirebaseAuth.getInstance().signOut();
                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    toast("user successfully logged out");
                    navigateToStart();
                }
        }
        displayFragment(fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void displayFragment(Fragment fragment) {
        if (fragment != null) {
            //Manually displaying the first fragment - one time only
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.commit();
        }
    }

    public void navigateToHome() {
        Intent intent = new Intent(Home.this, Home.class);
        startActivity(intent);
    }
    public void navigateToStart() {
        Intent intent = new Intent(Home.this, StartingPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    public void navigateToSettings() {
        Intent intent = new Intent(Home.this, SettingsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    public void toast(String a){
        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
    }
}
