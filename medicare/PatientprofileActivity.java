package com.ruth.jahan.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.TintableCheckedTextView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class PatientprofileActivity extends AppCompatActivity{
    private TextView patientprofilenametextview,patientprofileemailtextview,patientprofilephonetextview,
            patientprofileaddresstextview,patientprofilehometextview;
    private EditText time,weight;
    private Toolbar patientprofiletoolbarid;
    private Button graphbutton;
    GraphView graphView;
    LineGraphSeries lineGraphSeries;

    private FirebaseDatabase database;
    private DatabaseReference patientref,graphref;
    private FirebaseAuth mAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientprofile);


        patientprofilenametextview = findViewById(R.id.patientprofilenametextview);
        patientprofiletoolbarid = findViewById(R.id.patientprofiletoolbarid);
        setSupportActionBar(patientprofiletoolbarid);
        getSupportActionBar().setTitle("My Profile");
        patientprofileemailtextview = findViewById(R.id.patientprofileemailtextview);
        patientprofilephonetextview = findViewById(R.id.patientprofilephonetextview);
        patientprofileaddresstextview = findViewById(R.id.patientprofileaddresstextview);
        graphbutton = findViewById(R.id.graphbutton);
        time = findViewById(R.id.timetextview);
        weight = findViewById(R.id.weighttextview);
        graphView = findViewById(R.id.graph);
        lineGraphSeries = new LineGraphSeries();
        graphView.addSeries(lineGraphSeries);

        patientprofilehometextview = findViewById(R.id.patientprofilehometextview);
        mAuth = FirebaseAuth.getInstance();



        patientprofilehometextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(intent);
            }
        });
        patientref= FirebaseDatabase.getInstance().getReference().child("Patients").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        patientref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    patientprofilenametextview.setText(snapshot.child("pname").getValue().toString());
                    patientprofileemailtextview.setText(snapshot.child("pemail").getValue().toString());
                    patientprofilephonetextview.setText(snapshot.child("pphone").getValue().toString());
                    patientprofileaddresstextview.setText(snapshot.child("paddress").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        graphref = database.getReference("Chart");
        setListeners();

    }



    private void setListeners() {

        graphbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = graphref.push().getKey();
                int x = Integer.parseInt(time.getText().toString());
                int y = Integer.parseInt(weight.getText().toString());

                EnterGraphValue enterGraphValue = new EnterGraphValue(x,y);

                graphref.child(id).setValue(enterGraphValue);



            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        graphref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                DataPoint[] dp = new DataPoint[(int)snapshot.getChildrenCount()];
                int index= 0;

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    EnterGraphValue enterGraphValue = dataSnapshot.getValue(EnterGraphValue.class);
                    dp[index] = new DataPoint(enterGraphValue.getTime(),enterGraphValue.getWeight());
                    index++;
                }

                lineGraphSeries.resetData(dp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}