package com.ruth.jahan.medicare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MomchildCustomAdapter extends BaseAdapter {

    int[] flags;
    String[] parenting_tipsname;
    Context context;
    private LayoutInflater inflater;

    public MomchildCustomAdapter(Context context, String[] parenting_tipsname, int[] flags){

        this.context=context;
        this.parenting_tipsname=parenting_tipsname;
        this.flags=flags;
    }

    @Override
    public int getCount() {
        return parenting_tipsname.length;
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
        textView.setText(parenting_tipsname[position]);
        return convertView;
    }
}



