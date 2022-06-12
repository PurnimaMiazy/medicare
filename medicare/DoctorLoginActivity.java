package com.ruth.jahan.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class DoctorLoginActivity extends AppCompatActivity {

    private Button doctorloginbutton;
    private TextInputEditText doctorloginemail;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        mAuth = FirebaseAuth.getInstance();


        doctorloginbutton = findViewById(R.id.doctorloginbutton);
        doctorloginemail = findViewById(R.id.doctorloginemail);

        doctorloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(getApplicationContext(), PatientListActivity.class);
                    startActivity(intent);
            }
        });



    }
}