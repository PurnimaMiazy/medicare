package com.ruth.jahan.medicare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PatientlistAdapter extends ArrayAdapter<Patient> {

        private Activity context;
        private List<Patient> patientlist;

    public PatientlistAdapter(@NonNull Activity context, List<Patient> patientlist) {
        super(context, R.layout.sample_patient_list, patientlist);
        this.context = context;
        this.patientlist= patientlist;
    }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_patient_list,null,true);

        Patient patient = patientlist.get(position);

        TextView t1 = view.findViewById(R.id.patientlistnametextview);
        TextView  t2 = view.findViewById(R.id.patientlistphonetextview);
        TextView  t3 = view.findViewById(R.id.patientlistemailtextview);

        t1.setText( patient.getPname());
        t2.setText( patient.getPphone());
        t3.setText( patient. getPemail());




        return view;
    }


}


