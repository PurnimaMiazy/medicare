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

public class AmbulanceListActivity extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<Ambulancelist> listofambu;
    AmbulanceListAdapter ambulanceListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_list);

        databaseReference = FirebaseDatabase.getInstance().getReference("Ambulance List");

        listofambu = new ArrayList<>();
        ambulanceListAdapter = new AmbulanceListAdapter(AmbulanceListActivity.this,listofambu);


        listView = findViewById(R.id.ambulancelistviewid);

    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                listofambu.clear();
                for (DataSnapshot snapshot2 : snapshot.getChildren() ){
                    Ambulancelist ambulancelist = snapshot2.getValue(Ambulancelist.class);
                    listofambu.add(ambulancelist);
                }

                listView.setAdapter(ambulanceListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}