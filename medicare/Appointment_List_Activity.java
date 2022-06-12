package com.ruth.jahan.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Appointment_List_Activity extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<AppointmrntHolder> list;
   AppointmentAdapter appointmentAdapter;
   RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment__list_);

        recyclerView= findViewById(R.id.recyclerviewid);


        databaseReference = FirebaseDatabase.getInstance().getReference("Booking appointment").child("12-6-2022").child("Asst Prof Dr Aka-E-Dhuj Zaman");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AppointmrntHolder> options =
                new FirebaseRecyclerOptions.Builder<AppointmrntHolder>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Appointment"),AppointmrntHolder.class)
                        .build();

        appointmentAdapter = new AppointmentAdapter(options);
        recyclerView.setAdapter(appointmentAdapter);



    }


    @Override
    protected void onStart() {
        super.onStart();
        appointmentAdapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        appointmentAdapter.stopListening();
    }
}