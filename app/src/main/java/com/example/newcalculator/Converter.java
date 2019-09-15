package com.example.newcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Converter extends AppCompatActivity {

    private double km;
    DatabaseReference dref;
    String a,b;
    private double mb;
    private double l;
    private double deg;
    private double lb;
    private double c;
    private double inc;
    private  double result=0;

    private Button one ;
    private Button two ;
    private Button three;
    private Button four ;
    private Button five ;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private TextView input;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        setConvUI();
        dref= FirebaseDatabase.getInstance().getReference("Result");

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                km=Double.parseDouble(input.getText().toString());
                result=km*1000;
                a="km";
                b="m";
                Save(result,a,b,km);

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mb=Double.parseDouble(input.getText().toString());
                result=mb/1024;
                a="MB";
                b="GB";
                Save(result,a,b,mb);

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = Double.parseDouble(input.getText().toString());
                result=l*1000;
                a="L";
                b="ml";
                Save(result,a,b,l);

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deg= Double.parseDouble(input.getText().toString());
                result=(deg*3.1416)/180;
                a="deg";
                b="rad";
                Save(result,a,b,deg);

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lb=Double.parseDouble(input.getText().toString());
                result=lb/2.205;
                a="lb";
                b="kg";
                Save(result,a,b,lb);

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c= Double.parseDouble(input.getText().toString());
                result=(c*1.8)+32;
                a="C";
                b="F";
                Save(result,a,b,c);

            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inc= Double.parseDouble(input.getText().toString());
                result=inc*2.54;
                a="inch";
                b="cm";
                Save(result,a,b,inc);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(Double.toString(result));

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(null);
                output.setText(null);
                 a="";
                 b="";
                 mb=0;
                 l=0;
                 deg=0;
                 lb=0;
                 c=0;
                 inc=0;
                 result=0;

            }
        });

    }
    private void setConvUI(){
        one = (Button)findViewById(R.id.button1);
        two = (Button)findViewById(R.id.button2);
        three = (Button)findViewById(R.id.button3);
        four = (Button)findViewById(R.id.button4);
        five = (Button)findViewById(R.id.button5);
        six = (Button)findViewById(R.id.button6);
        seven = (Button)findViewById(R.id.button7);
        eight = (Button)findViewById(R.id.button8);
        nine = (Button)findViewById(R.id.button9);
        input = (TextView) findViewById(R.id.textview);
        output = (TextView) findViewById(R.id.textview2);
    }
    private void Save(double result,String a,String b,double other){
        String key=dref.push().getKey();
        dref.child(key).setValue(other+" "+a+"="+result+" "+b);
        Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
    }
}
