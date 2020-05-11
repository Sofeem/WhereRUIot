package com.example.whereruiot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Maplatlongsub extends AppCompatActivity {
    String latlonperson1;
    String latlonperson2;
    TextView person1;
    TextView loc1;
    TextView person2;
    TextView loc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maplatlongsub);
        Bundle bundle = getIntent().getExtras();
        latlonperson1 = bundle.getString("info");
        Bundle bundle1 = getIntent().getExtras();
        latlonperson2 =  bundle1.getString("info1");
        person1 = (TextView) findViewById(R.id.p1);
        loc1 = (TextView) findViewById(R.id.Location1);
        person2 = (TextView) findViewById(R.id.p2);
        loc2 = (TextView) findViewById(R.id.Location2);

        person1.setText("Aditya");
        loc1.setText(latlonperson1);
        person2.setText("Sereni");
        loc2.setText(latlonperson2);


    }
}
