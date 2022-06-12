package com.ruth.jahan.medicare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DiseaseCustomAdapter extends BaseAdapter {

    int[] flags;
    String[] diseasename;
    Context context;
    private LayoutInflater inflater;

    public DiseaseCustomAdapter(Context context, String[] diseasename, int[] flags){

        this.context=context;
        this.diseasename=diseasename;
        this.flags=flags;
    }

    @Override
    public int getCount() {
        return diseasename.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){

            inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.sample_list_view,parent,false);

        }

        ImageView imageView=(ImageView) convertView.findViewById(R.id.imageviewid);
        TextView textView=(TextView) convertView.findViewById(R.id.listitemnameid);
        imageView.setImageResource(flags[position]);
        textView.setText(diseasename[position]);
        return convertView;
    }
}
