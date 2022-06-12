package com.ruth.jahan.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class PatientRegActivity extends AppCompatActivity {

    private TextView pregpagequestion;
    private TextInputEditText pregfullname,pregphonenum,loginEmail,loginPass,pregaddress,pregage;
    private Spinner spinner;
    private Button patientsignupbutton;
    private FirebaseAuth mAuth;
    private DatabaseReference patientdatabaseref;
    private ProgressDialog loader;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_reg);
        this.setTitle("Patient Registration");


        pregpagequestion = findViewById(R.id.pregpagequestion);
        pregpagequestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientRegActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        spinner = findViewById(R.id.genderspinner);
        pregfullname = findViewById(R.id.pregfullname);
        pregphonenum = findViewById(R.id.pregphonenum);
        loginEmail = findViewById(R.id.loginEmail);
        loginPass = findViewById(R.id.loginPass);
        pregaddress = findViewById(R.id.pregaddress);
        pregage = findViewById(R.id.pregage);
        patientsignupbutton = findViewById(R.id.patientsignupbutton);
        loader = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        patientsignupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String pname = pregfullname.getText().toString().trim();
                final String pphone = pregphonenum.getText().toString().trim();
                final String pemail = loginEmail.getText().toString().trim();
                final String ppass = loginPass.getText().toString().trim();
                final String paddress = pregaddress.getText().toString().trim();
                final String page = pregage.getText().toString().trim();
                final String genderlist = spinner.getSelectedItem().toString();
                if (TextUtils.isEmpty(pname)) {
                    pregfullname.setError("Name is required!");
                    return;
                }
                if (TextUtils.isEmpty(pphone)) {
                    pregphonenum.setError("Phone number is required!");
                    return;
                }
                if (TextUtils.isEmpty(pemail)) {
                    loginEmail.setError("Email is required!");
                    return;
                }

                if (TextUtils.isEmpty(ppass)) {
                    loginPass.setError("Password is required!");
                    return;
                }
                if (TextUtils.isEmpty(paddress)) {
                    pregaddress.setError("Address is required!");
                    return;
                }

                if (TextUtils.isEmpty(page)) {
                    pregage.setError("Age is required!");
                    return;
                }

                if (genderlist.equals("Select Gender")){
                    Toast.makeText(PatientRegActivity.this,"Select your gender",Toast.LENGTH_SHORT).show();
                    return;
                }

                 else {
                    loader.setMessage("Registration in progress...");
                    loader.setCanceledOnTouchOutside(false);
                    loader.show();
                    mAuth.createUserWithEmailAndPassword(pemail, ppass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                String error = task.getException().toString();
                                Toast.makeText(PatientRegActivity.this, "Error occured: " + error,
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                String currentuserid = mAuth.getCurrentUser().getUid();
                                patientdatabaseref = FirebaseDatabase.getInstance().getReference().child("Patients").child(currentuserid);
                                HashMap patientinfo = new HashMap();
                                patientinfo.put("pname", pname);
                                patientinfo.put("pphone", pphone);
                                patientinfo.put("pemail", pemail);
                                patientinfo.put("paddress", paddress);
                                patientinfo.put("page", page);
                                patientinfo.put("pgender", genderlist);
                                patientinfo.put("type", "patient");
                                patientdatabaseref.updateChildren(patientinfo).addOnCompleteListener(new OnCompleteListener() {
                                    @Override
                                    public void onComplete(@NonNull Task task) {
                                        if (task.isSuccessful()) {
                                            Intent intent = new Intent(PatientRegActivity.this, PatientprofileActivity.class);
                                            startActivity(intent);
                                            finish();
                                            Toast.makeText(PatientRegActivity.this, "Registration successfull",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                                Toast.makeText(getApplicationContext(),"User is already registered",Toast.LENGTH_SHORT).show();
                                            }
                                        else {
                                                Toast.makeText(PatientRegActivity.this, task.getException().toString(),
                                                        Toast.LENGTH_SHORT).show();
                                                loader.dismiss();
                                            }
                                        }
                                        finish();
                                        loader.dismiss();
                                    }

                                });

                            }
                        }
                    });
                }
            }
        });
    }
}