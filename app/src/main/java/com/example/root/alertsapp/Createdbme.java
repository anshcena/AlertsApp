package com.example.root.alertsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Createdbme extends AppCompatActivity {

    TextView back1;
    TextView tn1,tn2,tn3,t1,t2,t3,s1,s2,s3,rs1,rs2,rs3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createdbme);
        back1=(TextView)findViewById(R.id.backtomyalerts1);

        tn1=(TextView)findViewById(R.id.textView44);
        tn2=(TextView)findViewById(R.id.textView49);
        tn3=(TextView)findViewById(R.id.textView53);

        t1=(TextView)findViewById(R.id.textView45);
        t2=(TextView)findViewById(R.id.textView50);
        t3=(TextView)findViewById(R.id.textView54);

        s1=(TextView)findViewById(R.id.textView48);
        s2=(TextView)findViewById(R.id.textView51);
        s3=(TextView)findViewById(R.id.textView55);

        rs1=(TextView)findViewById(R.id.textView52);
        rs2=(TextView)findViewById(R.id.textView56);
        rs3=(TextView)findViewById(R.id.textView57);









        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Createdbme.this,Myalerts.class);
                startActivity(intent);
            }
        });


    }
}

