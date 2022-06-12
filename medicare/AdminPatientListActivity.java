package com.ruth.jahan.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminPatientListActivity extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<Patient> patientlist;
    PatientlistAdapter patientlistadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_patient_list);


        databaseReference = FirebaseDatabase.getInstance().getReference("Patients");

        listView = findViewById(R.id.listviewid);


        patientlist = new ArrayList<>();
        patientlistadapter = new PatientlistAdapter(AdminPatientListActivity.this, patientlist);

    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                patientlist.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Patient patient = snapshot1.getValue(Patient.class);
                    patientlist.add(patient);
                }

                listView.setAdapter(patientlistadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();


    }
}