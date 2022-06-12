package com.ruth.jahan.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView loginpagequestion,adminloginquestion,loginpagedoctorquestion;
    private TextInputEditText loginemail,loginpass;
    private Button loginbutton;
    private FirebaseAuth mAuth;
    private ProgressDialog loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        loginpagequestion = findViewById(R.id.loginpagequestion);
        loginpagedoctorquestion = findViewById(R.id.loginpagedoctorquestion);
        adminloginquestion = findViewById(R.id.adminloginquestion);
        loginemail = findViewById(R.id.loginEmail);
        loginpass = findViewById(R.id.loginPass);
        loginbutton = findViewById(R.id.loginbutton);
        loader = new ProgressDialog(this);

        loginpagequestion.setOnClickListener(this);
        loginbutton.setOnClickListener(this);
        adminloginquestion.setOnClickListener(this);
        loginpagedoctorquestion.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.loginbutton:
                userlogin();
            break;


            case R.id.loginpagequestion:
                Intent intent= new Intent(getApplicationContext(), PatientRegActivity.class);
                startActivity(intent);
                break;

            case R.id.loginpagedoctorquestion:
                Intent intent2= new Intent(getApplicationContext(), DoctorLoginActivity.class);
                startActivity(intent2);
                break;

            case R.id.adminloginquestion:
                Intent intent3= new Intent(getApplicationContext(), AdminLoginActivity.class);
                startActivity(intent3);
                break;



        }
    }

    private void userlogin() {
        final String email = loginemail.getText().toString().trim();
        final String pass = loginpass.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            loginemail.setError("Email is required!");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginemail.setError("Enter a valid email address");
            loginemail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            loginpass.setError("Password is required!");
            return;
        }

        if (pass.length() < 6) {
            loginpass.setError("Your password must carry atleast 6 characters");
            loginpass.requestFocus();
            return;
        }

        else {
            loader.setMessage("Logging in...");
            loader.setCanceledOnTouchOutside(false);
            loader.show();

            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(getApplicationContext(),HomePageActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                    else
                     {
                        Toast.makeText(getApplicationContext(), "Login unsuccessful",
                                Toast.LENGTH_SHORT).show();
                    }

                    loader.dismiss();
                }
            });


        }
    }
}