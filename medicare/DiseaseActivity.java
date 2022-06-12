package com.ruth.jahan.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class DiseaseActivity extends AppCompatActivity {

    private ListView listView;
    private String[] diseasename;
    private int[] flags= {R.drawable.back_pain,R.drawable.piles,R.drawable.tetanus,
            R.drawable.thalassemia,R.drawable.swine_flu, R.drawable.tonsillitis,
            R.drawable.tuberculosis,R.drawable.urinary_infection,R.drawable.vertigo};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        Intent intent = getIntent();

        diseasename= getResources().getStringArray(R.array.disease_name);
        listView=(ListView) findViewById(R.id.diseaselistviewid);

        DiseaseCustomAdapter adapter= new DiseaseCustomAdapter(this,diseasename,flags);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = diseasename[position];
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), BackpainActivity.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), PilesActivity.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), TetanusActivity.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(view.getContext(), ThalassemiaActivity.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(view.getContext(), SwineFlueActivity.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(view.getContext(), TonsillitisActivity.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(view.getContext(), TuberculosisActivity.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(view.getContext(), UrinaryTractInfectionActivity.class);
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(view.getContext(), VirtigoActivity.class);
                    startActivity(intent);
                }
            }

        });



    }
}