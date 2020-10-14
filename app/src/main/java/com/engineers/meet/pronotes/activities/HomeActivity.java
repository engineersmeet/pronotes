package com.engineers.meet.pronotes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.engineers.meet.pronotes.R;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    AppCompatImageView drawerButton;
    DrawerLayout drawer;
    NavigationView navigationView;

    ImageView navigationUserImage;
    TextView navigationUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerButton = findViewById(R.id.home_drawer_button);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationUserImage = navigationView.getHeaderView(0).findViewById(R.id.navigation_user_image);
        navigationUserName = navigationView.getHeaderView(0).findViewById(R.id.navigation_user_name);

        navigationUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(HomeActivity.this, SignInActivity.class), 200);
            }
        });

        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.nav_create_notes:
                        startActivity(new Intent(HomeActivity.this, CreateNotesActivity.class));
                        break;
                    case R.id.nav_my_notes:
                        startActivity(new Intent(HomeActivity.this, MyNotesActivity.class));
                        break;
                    case R.id.nav_setting:
                        startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                        break;
                    case R.id.nav_share:
                        break;
                    case R.id.nav_help:
                        break;
                    case R.id.nav_about:
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 200){
            navigationUserName.setText(data.getStringExtra("username"));
        }
    }
}
