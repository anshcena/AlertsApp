package com.example.root.alertsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Task_details extends AppCompatActivity {

    Button bcktohome,sendtoauth;
    Spinner to;
    String geto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        bcktohome=(Button)findViewById(R.id.bcktohome);
        sendtoauth=(Button)findViewById(R.id.sendtoauth);
        to=(Spinner)findViewById(R.id.tofromprofile);


        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.profilelist, android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        to.setAdapter(adapter4);

        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                geto=to.getOnItemSelectedListener().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bcktohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iii=new Intent(Task_details.this,home.class);
                startActivity(iii);

            }
        });

    }
}
