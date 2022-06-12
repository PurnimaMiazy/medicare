package com.ruth.jahan.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class HealthtipsActivity extends AppCompatActivity {

    private ListView listView;
    private String[] health_tipsname;
    private int[] flags= {R.drawable.good_way_to_gain_weight,R.drawable.phy_activity,R.drawable.phy_activity_guide,
            R.drawable.smart_approach_to_weight_loss,R.drawable.healthy_eating_plan,R.drawable.use_inhaler,
            R.drawable.heart_healthy,R.drawable.kidney_healthy,R.drawable.liver_healthy,R.drawable.breast_cancer,R.drawable.va,R.drawable.vb,R.drawable.vb12,
            R.drawable.vc,R.drawable.vd,R.drawable.ve, R.drawable.vk};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthtips);

        Intent intent = getIntent();

        health_tipsname= getResources().getStringArray(R.array.health_tips_name);
        listView=(ListView) findViewById(R.id.healthtipslistviewid);

        CustomAdapter adapter= new CustomAdapter(this,health_tipsname,flags);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = health_tipsname[position];
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), GainWeightActivity.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), PhysicalActivity.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), PhysicalGuideActivity.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(view.getContext(), WeightLossActivity.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(view.getContext(), HealthyEatingPlanActivity.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(view.getContext(), UseInhalerActivity.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(view.getContext(), KeepHeartHealthyActivity.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(view.getContext(), KeepKidneyHealthyActivity.class);
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(view.getContext(), KeepLiverHealthyActivity.class);
                    startActivity(intent);
                }else if (position == 9) {
                    Intent intent = new Intent(view.getContext(), BreastCancerActivity.class);
                    startActivity(intent);
                }else if (position == 10) {
                    Intent intent = new Intent(view.getContext(), VitaminAActivity.class);
                    startActivity(intent);
                }else if (position == 11) {
                    Intent intent = new Intent(view.getContext(), VitaminBActivity.class);
                    startActivity(intent);
                }else if (position == 12) {
                    Intent intent = new Intent(view.getContext(), VitaminB12Activity.class);
                    startActivity(intent);
                }else if (position == 13) {
                    Intent intent = new Intent(view.getContext(), VitaminCActivity.class);
                    startActivity(intent);
                }else if (position == 14) {
                    Intent intent = new Intent(view.getContext(), VitaminDActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}