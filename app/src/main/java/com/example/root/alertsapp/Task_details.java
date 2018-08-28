package com.example.root.alertsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Task_details extends AppCompatActivity {

    Button bcktohome,sendtoauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        bcktohome=(Button)findViewById(R.id.bcktohome);
        sendtoauth=(Button)findViewById(R.id.sendtoauth);


        bcktohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iii=new Intent(Task_details.this,home.class);
                startActivity(iii);

            }
        });

    }
}
