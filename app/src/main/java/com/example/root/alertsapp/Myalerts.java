package com.example.root.alertsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Myalerts extends AppCompatActivity {

    Button cbm,abm;                       //created by me ,accepted by me

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myalerts);
        cbm=(Button)findViewById(R.id.createdbyme);
        abm=(Button)findViewById(R.id.acceptedbyme);


        cbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(Myalerts.this,Createdbme.class);

            startActivity(ii);

            }
        });

        abm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Myalerts.this,Acceptedbme.class);
                startActivity(i);

            }
        });





    }
    @Override
    public void onBackPressed() {
     Intent i=new Intent(Myalerts.this,home.class);
     startActivity(i);
        //  super.onBackPressed();
    }
}
