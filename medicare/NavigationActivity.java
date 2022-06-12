package com.ruth.jahan.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.okhttp.internal.DiskLruCache;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerlayout;
    private Toolbar toolbar;
    private NavigationView nav_view;
    private TextView nav_user_full_name;
    private DatabaseReference patientref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        toolbar = findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Medi Care App");

        drawerlayout = findViewById(R.id.drawerlayout);
        nav_view = findViewById(R.id.nav_view);


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(NavigationActivity.this,drawerlayout,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerlayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        nav_user_full_name = nav_view.getHeaderView(0).findViewById(R.id.nav_user_full_name);

        nav_view.setNavigationItemSelectedListener(this);

        patientref= FirebaseDatabase.getInstance().getReference().child("Patients").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        patientref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String name = snapshot.child("pname").getValue().toString();
                    nav_user_full_name.setText(name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}