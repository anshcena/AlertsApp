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
    TextView t1,t2,t3,s1,s2,s3;
    TextView da1,da2,da3,tc1,tc2,tc3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allalertss);
        report=(Button)findViewById(R.id.reports);
        backtomyalerts2=(TextView)findViewById(R.id.backtomyalerts2);

        t1=(TextView)findViewById(R.id.textView46);
        t2=(TextView)findViewById(R.id.textView58);
        t3=(TextView)findViewById(R.id.textView62);

        s1=(TextView)findViewById(R.id.textView47);
        s2=(TextView)findViewById(R.id.textView59);
        s3=(TextView)findViewById(R.id.textView63);

        da1=(TextView)findViewById(R.id.textView57);
        da1=(TextView)findViewById(R.id.textView60);
        da1=(TextView)findViewById(R.id.textView64);

        tc1=(TextView)findViewById(R.id.textView61);
        tc2=(TextView)findViewById(R.id.textView65);
        tc3=(TextView)findViewById(R.id.textView90);






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
