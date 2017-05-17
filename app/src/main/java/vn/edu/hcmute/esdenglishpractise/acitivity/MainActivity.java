package vn.edu.hcmute.esdenglishpractise.acitivity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;

import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.database.DatabaseHelper;
import vn.edu.hcmute.esdenglishpractise.fragment.AboutFragment;
import vn.edu.hcmute.esdenglishpractise.fragment.CustomSpeakingFragment;
import vn.edu.hcmute.esdenglishpractise.fragment.HomeFragment;
import vn.edu.hcmute.esdenglishpractise.fragment.SettingFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    Toolbar toolbar = null;
    DrawerLayout drawer = null;
    NavigationView navigationView = null;
    DatabaseHelper databaseHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set initial fragment
        Fragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frmContent, homeFragment);
        transaction.commit();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        databaseHelper = new DatabaseHelper(this);
        try {
            databaseHelper.CreateDatabase();
        } catch (IOException e) {
            Log.d(TAG, "Fail to load database");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
        } else if (id == R.id.nav_speaking) {
            fragment = new CustomSpeakingFragment();
        } else if (id == R.id.nav_about) {
            fragment = new AboutFragment();
        } else if (id == R.id.nav_setting) {
            fragment = new SettingFragment();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        // Insert the fragment by replacing any existing fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frmContent, fragment);
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
