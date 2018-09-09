package com.example.root.alertsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Acceptedbme extends AppCompatActivity {

    TextView backtomyalert;
    TextView tn1,tn2,tn3,t1,t2,t3,s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceptedbme);
        backtomyalert=(TextView)findViewById(R.id.backtomyalerts);

        tn1=(TextView)findViewById(R.id.textView66);
        tn2=(TextView)findViewById(R.id.textView69);
        tn3=(TextView)findViewById(R.id.textView72);

        t1=(TextView)findViewById(R.id.textView67);
        t2=(TextView)findViewById(R.id.textView70);
        t3=(TextView)findViewById(R.id.textView73);

        s1=(TextView)findViewById(R.id.textView71);
        s2=(TextView)findViewById(R.id.textView74);
        s3=(TextView)findViewById(R.id.textView77);



        tn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Acceptedbme.this,Task_details.class);
                r.putExtra("tasknumber1",tn1.toString());
                startActivity(r);
            }
        });

        tn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Acceptedbme.this,Task_details.class);
                r.putExtra("tasknumber2",tn2.toString());
                startActivity(r);
            }
        });

        tn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Acceptedbme.this,Task_details.class);
                r.putExtra("tasknumber3",tn3.toString());
                startActivity(r);
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rr=new Intent(Acceptedbme.this,Task_details.class);
                rr.putExtra("task1",t1.toString());
                startActivity(rr);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rr=new Intent(Acceptedbme.this,Task_details.class);
                rr.putExtra("task2",t2.toString());
                startActivity(rr);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rr=new Intent(Acceptedbme.this,Task_details.class);
                rr.putExtra("task3",t3.toString());
                startActivity(rr);
            }
        });

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Acceptedbme.this,Task_details.class);
                startActivity(intent);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Acceptedbme.this,Task_details.class);
                startActivity(intent);
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Acceptedbme.this,Task_details.class);
                startActivity(intent);
            }
        });


        backtomyalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ba=new Intent(Acceptedbme.this,Myalerts.class);
                startActivity(ba);
            }
        });


    }
}
