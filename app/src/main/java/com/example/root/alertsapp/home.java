package com.example.root.alertsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class home extends AppCompatActivity {


    Button createalert,myalerts,allalerts;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        createalert=(Button)findViewById(R.id.createalert);
        myalerts=(Button)findViewById(R.id.myalert);
        allalerts=(Button)findViewById(R.id.allalerts);

        logout=(TextView)findViewById(R.id.logout);
        


    }
}
