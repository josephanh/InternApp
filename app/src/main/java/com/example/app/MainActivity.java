package com.example.app;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.app.Fragments.ChartFragment;
import com.example.app.Fragments.HomeFragment;
import com.example.app.Fragments.NotificationFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView titleApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        transparent statusBar
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation);
        titleApp = findViewById(R.id.title_app);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_left);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = new HomeFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
        titleApp.setText("Báo cáo tuần");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                if (item.getItemId() == R.id.home_repost) {
                    fragment = new HomeFragment();
                    titleApp.setText("Báo cáo tuần");
                } else if (item.getItemId() == R.id.notification) {
                    fragment = new NotificationFragment();
                    titleApp.setText("Thông báo");
                } else if (item.getItemId() == R.id.chart) {
                    fragment = new ChartFragment();
                    titleApp.setText("Thống kê");
                }
                else {
                    fragment = new HomeFragment();
                    titleApp.setText("Báo cáo tuần");
                }
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            navigationView.setItemIconTintList(null);
        }
        return super.onOptionsItemSelected(item);
    }


}