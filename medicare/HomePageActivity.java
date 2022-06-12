package com.ruth.jahan.medicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView healthcardview,diseasecardview,mothercardview,bmicardview,doctorcardview,logoutcardview,ambulancecardview,myprofilecardviewid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        healthcardview = findViewById(R.id.healthcardviewid);
        diseasecardview = findViewById(R.id.diseasecardviewid);
        mothercardview = findViewById(R.id.mothercardviewid);
        bmicardview = findViewById(R.id.bmicardviewid);
        doctorcardview = findViewById(R.id.doctorlistcardviewid);
        ambulancecardview = findViewById(R.id.ambulancecardviewid);
        logoutcardview = findViewById(R.id.logoutcardviewid);
        myprofilecardviewid = findViewById(R.id.myprofilecardviewid);


        healthcardview.setOnClickListener(this);
        diseasecardview.setOnClickListener(this);
        mothercardview.setOnClickListener(this);
        bmicardview.setOnClickListener(this);
        doctorcardview.setOnClickListener(this);
        ambulancecardview.setOnClickListener(this);
        logoutcardview.setOnClickListener(this);
        myprofilecardviewid.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId()== R.id.healthcardviewid){
            Intent intent = new Intent(HomePageActivity.this, HealthtipsActivity.class);
            startActivity(intent);

        }
        else if (view.getId()== R.id.diseasecardviewid){
            Intent intent = new Intent(HomePageActivity.this, DiseaseActivity.class);
            startActivity(intent);

        }
        else if (view.getId()== R.id.mothercardviewid){
            Intent intent = new Intent(HomePageActivity.this, MomchildActivity.class);
            startActivity(intent);

        }
        else if (view.getId()== R.id.bmicardviewid){
            Intent intent = new Intent(HomePageActivity.this, BmiActivity.class);
            startActivity(intent);

        }
        else if (view.getId()== R.id.doctorlistcardviewid){
            Intent intent = new Intent(HomePageActivity.this, DoctorlistActivity.class);
            startActivity(intent);

        }
        else if (view.getId()== R.id.ambulancecardviewid){
            Intent intent = new Intent(HomePageActivity.this, AmbulanceListActivity.class);
            startActivity(intent);

        }

        else if (view.getId()== R.id.myprofilecardviewid){
            Intent intent = new Intent(HomePageActivity.this, PatientprofileActivity.class);
            startActivity(intent);

        }

        else if (view.getId()== R.id.logoutcardviewid) {
            Intent intent = new Intent(HomePageActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}