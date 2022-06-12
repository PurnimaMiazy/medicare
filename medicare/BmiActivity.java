package com.ruth.jahan.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.grpc.internal.DnsNameResolver;

public class BmiActivity extends AppCompatActivity {
    private EditText weightid,heightid;
    private TextView resultid;
    String calculation,bmiresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        weightid = findViewById(R.id.weightid);
        heightid = findViewById(R.id.heightid);
        resultid =findViewById(R.id.resultid);



    }

    public void calculateBMI(View view) {
        String s1 = weightid.getText().toString();
        String s2 = heightid.getText().toString();

        float weightValue = Float.parseFloat(s1);
        float heightValue = Float.parseFloat(s2)/100;


        float bmi = weightValue/(heightValue * heightValue);

        if (bmi<16){
            bmiresult = "Severely Under Weight";
        }
        else if(bmi<18.5 && bmi>16){
            bmiresult = "Under Weight";
        }
        else if(bmi>=18.5 && bmi<=24.9){
            bmiresult = "Normal and Healthy";
        }
        else if(bmi>=25 && bmi<=29.9){
            bmiresult = "Overweight";
        }
        else {
            bmiresult = "Obese";
        }

        calculation = "BMI : " + bmi + "\n\nWeight Status : " + bmiresult;
        resultid.setText(calculation);
    }
}