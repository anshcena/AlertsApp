package com.example.root.alertsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class createalert extends AppCompatActivity {

    Spinner section,line,profile,depart,machine,task,prof;
    Button back,createalertbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createalert);

        section=(Spinner)findViewById(R.id.section);
        line=(Spinner)findViewById(R.id.line);
        profile=(Spinner)findViewById(R.id.profile);
        depart=(Spinner)findViewById(R.id.department);
        machine=(Spinner)findViewById(R.id.machine);
        task=(Spinner)findViewById(R.id.task);
        prof=(Spinner)findViewById(R.id.prof);

        back=(Button)findViewById(R.id.back);
        createalertbutton=(Button)findViewById(R.id.createalertbutton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(createalert.this,home.class);
                startActivity(i);
            }
        });







    }
}
