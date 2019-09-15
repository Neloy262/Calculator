package com.example.newcalculator;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private Activity context;
    private  List<String> resultlist;
    public CustomAdapter( Activity context, List<String> resultlist) {
        super(context, R.layout.sample_layout,resultlist);
        this.context=context;
        this.resultlist=resultlist;
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);

        String val=resultlist.get(position);
        TextView t1=view.findViewById(R.id.textView);

        t1.setText(val);
        return view;
    }
}
