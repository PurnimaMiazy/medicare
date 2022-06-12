package com.ruth.jahan.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MomchildActivity extends AppCompatActivity {

    private ListView listView;
    private String[] parenting_tipsname;
    private int[] flags= {R.drawable.prenatal_care,R.drawable.postnatal_care,R.drawable.menstrual_problem,
            R.drawable.miscarriage,R.drawable.high_risk_pregnancy};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_momchild);

        Intent intent = getIntent();

        parenting_tipsname= getResources().getStringArray(R.array.parental_care);
        listView=(ListView) findViewById(R.id.parentinglistviewid);

        MomchildCustomAdapter adapter= new MomchildCustomAdapter(this,parenting_tipsname,flags);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = parenting_tipsname[position];
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), PrenatalCareActivity.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), PostnatalCareActivity.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), MenstrualProblemsActivity.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(view.getContext(), MiscarriageActivity.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(view.getContext(), HighRiskPregnancyActivity.class);
                    startActivity(intent);
                }
            }

        });
    }
}