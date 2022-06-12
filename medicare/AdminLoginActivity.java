package com.ruth.jahan.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLoginActivity extends AppCompatActivity {

    private TextInputEditText adminloginpass;
    private Button adminloginbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        this.setTitle("Admin Page");

        adminloginpass = findViewById(R.id.adminloginPass);
        adminloginbutton = findViewById(R.id.adminloginbutton);

        adminloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password= adminloginpass.getText().toString().trim();

                if(password.equals("adminpass")) {
                    Intent intent = new Intent(AdminLoginActivity.this, AdminActivity.class);
                    startActivity(intent);
                    finish();
                }

                else {
                    Toast.makeText(getApplicationContext(), "Incorrect password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}