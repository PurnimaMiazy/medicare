package com.ruth.jahan.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddAmbulanceActivity extends AppCompatActivity {

    private Button ambulistsavebutton;
    private TextInputEditText addambulistname,addambulistdriver,addambulistphone;
    private FirebaseAuth mAuth;
    private DatabaseReference ambulancelistdatabaseref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ambulance);

        ambulancelistdatabaseref = FirebaseDatabase.getInstance().getReference("Ambulance List");


        addambulistname = findViewById(R.id.addambulistname);
        addambulistdriver = findViewById(R.id.addambulistdriver);
        addambulistphone = findViewById(R.id.addambulistphone);
        ambulistsavebutton = findViewById(R.id.ambulistsavebutton);
        mAuth = FirebaseAuth.getInstance();


        ambulistsavebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Saveambulancedata();
            }

            private void Saveambulancedata() {
                String ambuname = addambulistname.getText().toString().trim();
                String ambudriver = addambulistdriver.getText().toString().trim();
                String ambuphone = addambulistphone.getText().toString().trim();


                if (TextUtils.isEmpty(ambuname)) {
                    addambulistname.setError("Name is required!");
                    return;
                }
                if (TextUtils.isEmpty(ambudriver)) {
                    addambulistdriver.setError("This field is required!");
                    return;
                }
                if (TextUtils.isEmpty(ambuphone)) {
                    addambulistphone.setError("This field is required!");
                    return;
                }


                else {

                    String key2 = ambulancelistdatabaseref.push().getKey();
                    Ambulancelist ambulancelist = new Ambulancelist(ambuname, ambudriver, ambuphone);
                    ambulancelistdatabaseref.child(key2).setValue(ambulancelist);
                    Toast.makeText(getApplicationContext(), "Ambulance Info Is Added", Toast.LENGTH_LONG).show();
                }


                addambulistname.setText("");
                addambulistdriver.setText("");
                addambulistphone.setText("");


            }
        });
    }
}