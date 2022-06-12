package com.ruth.jahan.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    private Button admindoctorlistbutton,adminpatientlistbutton,adminadddoctorlistbutton,adminaddambulancelistbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        admindoctorlistbutton = findViewById(R.id.admindoctorlistbutton);
        adminpatientlistbutton = findViewById(R.id.adminpatientlistbutton);
        adminadddoctorlistbutton = findViewById(R.id.adminadddoctorlistbutton);
        adminaddambulancelistbutton = findViewById(R.id.adminaddambulancelistbutton);

        adminpatientlistbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this,AdminPatientListActivity.class);
                startActivity(intent);
            }
        });

        admindoctorlistbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, AdminDoctorListActivity.class);
                startActivity(intent);

            }
        });

        adminadddoctorlistbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, AddDoctorActivity.class);
                startActivity(intent);

            }
        });

        adminaddambulancelistbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, AddAmbulanceActivity.class);
                startActivity(intent);
            }
        });
    }

    public void btnDelete_click(View view) {

    }
}