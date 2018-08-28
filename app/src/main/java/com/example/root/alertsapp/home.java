package com.example.root.alertsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class home extends AppCompatActivity {


    Button createalert1,myalert,allalerts;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        createalert1=(Button)findViewById(R.id.createalert);
        myalert=(Button)findViewById(R.id.myalert);
        allalerts=(Button)findViewById(R.id.allalert1);

        logout=(TextView)findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(home.this,MainActivity.class);
                startActivity(i);
            }
        });

        createalert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(home.this,createalert.class);
                startActivity(ii);
            }
        });

        myalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(home.this,Myalerts.class);
                startActivity(intent);

            }
        });

        allalerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(home.this,Allalertss.class);
                startActivity(ii);
            }
        });


    }
}
