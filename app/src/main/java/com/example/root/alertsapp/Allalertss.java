package com.example.root.alertsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Allalertss extends AppCompatActivity {

    Button report;
    TextView backtomyalerts2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allalertss);
        report=(Button)findViewById(R.id.reports);
        backtomyalerts2=(TextView)findViewById(R.id.backtomyalerts2);

        backtomyalerts2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Allalertss.this,Myalerts.class);
                startActivity(intent);
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                //Intent ii=new Intent(Allalertss.this,)

            }
        });

    }
}
