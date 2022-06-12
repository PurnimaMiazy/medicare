package com.ruth.jahan.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminDoctorListActivity extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    DatabaseReference databaseReference;
    private List<Doctorslist> listofdoc;
    DoctorListAdapter doctorListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_doctor_list);

        databaseReference = FirebaseDatabase.getInstance().getReference("Doctors List");



        listofdoc = new ArrayList<>();
        doctorListAdapter = new DoctorListAdapter(AdminDoctorListActivity.this,listofdoc);


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
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}