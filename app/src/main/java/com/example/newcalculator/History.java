package com.example.newcalculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {
    private ListView listview;
    private List<String > resultlist;
    private CustomAdapter customAdapter;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        databaseReference= FirebaseDatabase.getInstance().getReference("Result");
        resultlist=new ArrayList<>();
        customAdapter=new CustomAdapter(History.this,resultlist);
        listview=findViewById(R.id.listview);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                resultlist.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    String s= (String) dataSnapshot1.getValue();
                    resultlist.add(s);
                }
                listview.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
