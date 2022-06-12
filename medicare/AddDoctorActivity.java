package com.ruth.jahan.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDoctorActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button doctorlistsavebutton;
    private TextInputEditText dlistfullname,dlistdegree,dlistspeciality,dlistemail,dlistphone;
    private FirebaseAuth mAuth;
    private DatabaseReference doctorlistdatabaseref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);
        doctorlistdatabaseref = FirebaseDatabase.getInstance().getReference("Doctors List");


        dlistfullname = findViewById(R.id.dlistfullname);
        dlistdegree = findViewById(R.id.dlistdegree);
        dlistspeciality = findViewById(R.id.dlistspeciality);
        dlistemail = findViewById(R.id.dlistemail);
        dlistphone = findViewById(R.id.dlistphone);
        spinner = findViewById(R.id.depertmentspinner);
        doctorlistsavebutton = findViewById(R.id.doctorlistsavebutton);
        mAuth = FirebaseAuth.getInstance();


        doctorlistsavebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Savedoctordata();
            }

            private void Savedoctordata() {
                 String docname = dlistfullname.getText().toString().trim();
                 String docdegree = dlistdegree.getText().toString().trim();
                 String docspeciality = dlistspeciality.getText().toString().trim();
                 String docemail = dlistemail.getText().toString().trim();
                 String docphone = dlistphone.getText().toString().trim();
                 String depertmentlist = spinner.getSelectedItem().toString();




                if (TextUtils.isEmpty(docname)) {
                    dlistfullname.setError("Name is required!");
                    return;
                }
                if (TextUtils.isEmpty(docdegree)) {
                    dlistdegree.setError("This field is required!");
                    return;
                }
                if (TextUtils.isEmpty(docspeciality)) {
                    dlistspeciality.setError("This field is required!");
                    return;
                }

                if (TextUtils.isEmpty(docemail)) {
                    dlistemail.setError("This field is required!");
                    return;
                }
                if (TextUtils.isEmpty(docphone)) {
                    dlistphone.setError("This field is required!");
                    return;
                }

                if (depertmentlist.equals("Select Depertment")){
                    Toast.makeText(AddDoctorActivity.this,"Select your depertment",Toast.LENGTH_SHORT).show();
                    return;
                }

                else {


                    String key = doctorlistdatabaseref.push().getKey();
                    Doctorslist doctorslist = new Doctorslist(docname, docdegree, docspeciality, docemail, docphone, depertmentlist);
                    doctorlistdatabaseref.child(key).setValue(doctorslist);
                    Toast.makeText(getApplicationContext(), "Doctor Info Is Added", Toast.LENGTH_LONG).show();

                }



                dlistfullname.setText("");
                dlistdegree.setText("");
                dlistspeciality.setText("");
                dlistemail.setText("");
                dlistphone.setText("");




            }
        });
    }
}