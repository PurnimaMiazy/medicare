package com.ruth.jahan.medicare;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;

public class DoctorListAdapter extends ArrayAdapter<Doctorslist> {

    private Activity context;
    private List<Doctorslist> listofdoc;

    public DoctorListAdapter(@NonNull Activity context, List<Doctorslist> listofdoc) {
        super(context, R.layout.sample_doctor_list, listofdoc);
        this.context = context;
        this.listofdoc = listofdoc;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_doctor_list,null,true);

        Doctorslist doctorslist = listofdoc.get(position);

        TextView t1 = view.findViewById(R.id.doctorlistnametextview);
        TextView  t2 = view.findViewById(R.id.doctorlistdegreetextview);
        TextView  t3 = view.findViewById(R.id.doctorlistspecialitytextview);
        TextView  t4 = view.findViewById(R.id.doctorlistphonetextview);

        t1.setText(doctorslist.getDocname());
        t2.setText(doctorslist.getDocdegree());
        t3.setText(doctorslist.getDocspeciality());
        t4.setText(doctorslist.getDocphone());



        return view;
    }
}
