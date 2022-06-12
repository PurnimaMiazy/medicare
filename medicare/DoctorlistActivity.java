package com.ruth.jahan.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DoctorlistActivity extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<Doctorslist> listofdoc;
    DoctorListAdapter doctorListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorlist);

        databaseReference = FirebaseDatabase.getInstance().getReference("Doctors List");




        listofdoc = new ArrayList<>();
        doctorListAdapter = new DoctorListAdapter(DoctorlistActivity.this,listofdoc);


        listView = findViewById(R.id.doclistviewid);

    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                listofdoc.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren() ){
                    Doctorslist doctorslist = snapshot1.getValue(Doctorslist.class);
                    listofdoc.add(doctorslist);
                }

                listView.setAdapter(doctorListAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent= new Intent(DoctorlistActivity.this,Appointment.class);

                        //Doctorslist doctorslist =new Doctorslist();
                        String a= listofdoc.get(i).getDocname();

                        intent.putExtra("Key", a);
                        startActivity(intent);

                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();


    }
}