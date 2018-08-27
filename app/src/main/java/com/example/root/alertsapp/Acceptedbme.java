package com.example.root.alertsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Acceptedbme extends AppCompatActivity {

    TextView backtomyalert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceptedbme);
        backtomyalert=(TextView)findViewById(R.id.backtomyalerts);



        backtomyalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ba=new Intent(Acceptedbme.this,Myalerts.class);
                startActivity(ba);
            }
        });


    }
}
