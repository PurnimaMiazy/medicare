package com.ruth.jahan.medicare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AmbulanceListAdapter extends ArrayAdapter<Ambulancelist> {

    private Activity context;
    private List<Ambulancelist> listofambu;

    public AmbulanceListAdapter(@NonNull Activity context, List<Ambulancelist> listofambu) {
        super(context, R.layout.sample_ambulance_list, listofambu);
        this.context = context;
        this.listofambu = listofambu;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_ambulance_list,null,true);

        Ambulancelist ambulancelist = listofambu.get(position);

        TextView t1 = view.findViewById(R.id.ambulancenametextview);
        TextView  t2 = view.findViewById(R.id.ambulancedrivertextview);
        TextView  t3 = view.findViewById(R.id.ambulancephonetextview);


        t1.setText(ambulancelist.getAmbuname());
        t2.setText(ambulancelist.getAmbudriver());
        t3.setText(ambulancelist.getAmbuphone());


        return view;
    }
}