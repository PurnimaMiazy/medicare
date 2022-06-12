package com.ruth.jahan.medicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Appointment extends AppCompatActivity {

    Button appointment, encrypt;
    EditText date,getDate,time, blood,problem;
    DatePickerDialog datePickerDialog;
    public String encryptedBlood,encryptedProblem, count;


    TextView serial, doctorName;

    Spinner schedule;
    String[] times={"9.00-9.30","9.30-10.00","10.00-10.30","10.30-11.00","11.00-11.30"};
    int j,position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        doctorName = findViewById(R.id.dr_name);
        blood = findViewById(R.id.Blood_group);
        problem = findViewById(R.id.problem);
        encrypt = findViewById(R.id.encrypt);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                     encryptedBlood = "";
                    try {
                        encryptedBlood = Aes256Class.encrypt(blood.getText().toString());
                        encryptedProblem = Aes256Class.encrypt(problem.getText().toString());
                        Toast.makeText(Appointment.this,"The encripted data of blood: "+ encryptedBlood +"\n"+"The encripted data of Problem: "+encryptedProblem,Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
        });

        Intent intent = getIntent();
        String DoctorName = intent.getStringExtra("Key");
        doctorName.setText(DoctorName);

        date = findViewById(R.id.date);
        appointment= findViewById(R.id.appointment);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Appointment.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "-"
                                        + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        schedule = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,times);
        schedule.setAdapter(arrayAdapter);


        j=0;

        schedule.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                position = adapterView.getSelectedItemPosition();
                String item = adapterView.getItemAtPosition(i).toString();
                if( schedule.getSelectedItem()!= null && j<times.length){
                    j++;
                    count = String.valueOf(j);
                    serial = findViewById(R.id.serial);
                    serial.setText(String.valueOf(j));
                }else {
                    schedule.setEnabled(false);
                }
                time = findViewById(R.id.time);
                time.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        String getTime =schedule.getSelectedItem().toString();
        time = findViewById(R.id.time);
        time.setText(getTime);

    }
    public void result(View view) {
        getDate = findViewById(R.id.getDate);
        getDate.setText(date.getText().toString());
    }

    public void send(View view) {
        String DATE = getDate.getText().toString().trim();
        //String BLOOD = blood.getText().toString().trim();
        String BLOOD = encryptedBlood.trim();
        String PROBLEM = encryptedProblem.trim();

        String TIME = time.getText().toString().trim();
        String SERIAL = serial.getText().toString().trim();



        AppointmrntHolder object = new AppointmrntHolder(TIME,BLOOD,PROBLEM);
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference node = database.getReference("Booking appointment");
        node.child(DATE).child(SERIAL).setValue(object);

        /*database.getReference("Booking appointment").
                child(String.valueOf(database.getReference("Doctors List").child(KEY)))
                        .child(DATE).setValue(object);*/



        getDate.setText("");
        time.setText("");
       // doctorName.setText("");
       blood.setText("");
       problem.setText("");


        Toast.makeText(Appointment.this,"Appointment completed \n"+"Serial Number: "+ count ,Toast.LENGTH_SHORT).show();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //The code here will run after 5 sec, do what you want
                NotificationManager mNotificationManager;

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(getApplicationContext(), "notify_001");


                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
                bigText.bigText("You have an appointment with "+ doctorName.getText().toString() + " on " + "serial number" + count +"!");
                bigText.setBigContentTitle("MediCare");
                bigText.setSummaryText("Text in detail");


                mBuilder.setSmallIcon(R.drawable.ic_baseline_notifications_active_24);
                mBuilder.setContentTitle("MediCare");
                mBuilder.setContentText("You have an appointment with "+ doctorName.getText().toString() + " on " + "serial number" + count+ "!");
                //mBuilder.setSubText(" ");
                mBuilder.setPriority(Notification.PRIORITY_MAX);
//                mBuilder.setStyle(bigText);

                mNotificationManager =
                        (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

// === Removed some obsoletes
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                {
                    String channelId = "Your_channel_id";
                    NotificationChannel channel = new NotificationChannel(
                            channelId,
                            "Channel human readable title",
                            NotificationManager.IMPORTANCE_HIGH);
                    mNotificationManager.createNotificationChannel(channel);
                    mBuilder.setChannelId(channelId);
                }

                mNotificationManager.notify(0, mBuilder.build());
//

            }
        }, 10*1000);

    }


}