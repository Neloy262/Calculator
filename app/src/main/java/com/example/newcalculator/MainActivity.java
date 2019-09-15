package com.example.newcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button one ;
    String c;
    double container;
    private Button two ;
    private Button conv;
    private Button his;
    private Button three;
    private Button four ;
    private Button five ;
    private Button six;
    private Button seven ;
    private Button eight ;
    private Button nine ;
    private Button zero;
    private Button clear ;
    private Button add ;
    private Button sub ;
    private Button mul ;
    private Button cnv ;
    private Button div ;
    private Button eq ;
    private TextView input;
    private TextView output ;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUAL = '0';
    private double val1 = Double.NaN;
    private  double val2;
    private char ACTION;
    DatabaseReference dref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dref= FirebaseDatabase.getInstance().getReference("Result");
        setContentView(R.layout.activity_main);
        setUI();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=ADDITION;
                output.setText(String.valueOf(val1) + "+");
                input.setText(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=MULTIPLICATION;
                output.setText(String.valueOf(val1) + "*");
                input.setText(null);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=SUBTRACTION;
                output.setText(String.valueOf(val1) + "-");
                input.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=DIVISION;
                output.setText(String.valueOf(val1) + "/");
                input.setText(null);
            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=EQUAL;
                output.setText(output.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                input.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                output.setText(null);
                input.setText(null);
                val1 = Double.NaN;
                val2=0;
                container=0;
                c="";
            }
        });
        conv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Converter.class);
                startActivity(intent);
            }
        });
        his.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,History.class);
                startActivity(intent);
            }
        });


    }
    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(input.getText().toString());
            switch(ACTION){
                case ADDITION:
                    container=val1;
                    val1=val1+val2;
                    c="+";

                    Save(val1,container,val2,c);
                    break;
                case MULTIPLICATION:
                    container=val1;
                    val1=val1*val2;
                    c="*";
                    Save(val1,container,val2,c);
                    break;
                case DIVISION:
                    container=val1;
                    val1=val1/val2;
                    c="/";
                    Save(val1,container,val2,c);
                    break;
                case SUBTRACTION:
                    container=val1;
                    val1=val1-val2;
                    c="-";
                    Save(val1,container,val2,c);
                    break;
                case EQUAL:
                    break;
            }
        }
        else{
            val1=Double.parseDouble(input.getText().toString());
        }
    }
    private void setUI(){
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        zero = (Button)findViewById(R.id.btn0);
        clear = (Button)findViewById(R.id.btnclr);
        add = (Button)findViewById(R.id.btnplus);
        sub = (Button)findViewById(R.id.btnminus);
        mul = (Button)findViewById(R.id.btnmul);
        conv=(Button)findViewById(R.id.Conv);
        div = (Button)findViewById(R.id.btndiv);
        eq = (Button)findViewById(R.id.btneq);
        input = (TextView)findViewById(R.id.usrinput);
        output = (TextView)findViewById(R.id.usroutput);
        his=(Button)findViewById(R.id.history);
    }
    private void Save(double result,double val1,double val2,String sign){
        String key=dref.push().getKey();
        dref.child(key).setValue(val1+sign+val2+"="+result);
        Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
    }
}
