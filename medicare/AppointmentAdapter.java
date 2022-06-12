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
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AppointmentAdapter extends FirebaseRecyclerAdapter<AppointmrntHolder,AppointmentAdapter.myviewholder> {

    private myviewholder holder;
    private int position;
    private AppointmrntHolder appointmrntHolder;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AppointmentAdapter(@NonNull FirebaseRecyclerOptions<AppointmrntHolder> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull AppointmrntHolder appointmrntHolder) {
        String decrypted_blood = "", decrypted_problem = "";
        try {
            decrypted_blood= Aes256Class.decrypt(appointmrntHolder.getBlood().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            decrypted_blood= Aes256Class.decrypt(appointmrntHolder.getProblem().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.blood.setText( decrypted_blood );
        holder.problem.setText(decrypted_problem);
        holder.time.setText(appointmrntHolder.getTime());

    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_appointment_list,parent,false);
        return new myviewholder(view);
    }


    public class myviewholder extends RecyclerView.ViewHolder{

        TextView blood,problem,time;
        public myviewholder(@NonNull View itemView) {
            super(itemView);



           blood = (TextView)itemView.findViewById(R.id.blood);
            problem = (TextView)itemView.findViewById(R.id.prblm);
            time = (TextView)itemView.findViewById(R.id.time_);


        }
    }
}





