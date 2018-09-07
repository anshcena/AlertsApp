package com.example.root.alertsapp;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class createalert extends AppCompatActivity {

    private static final String TAG ="";
    Spinner section,line,profile,depart,machine,task,prof;
    Button back,createalertbutton,gobaacktohomefordailog;










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createalert);





        section=(Spinner)findViewById(R.id.spinner);
        line=(Spinner)findViewById(R.id.line);
        profile=(Spinner)findViewById(R.id.profile);
        depart=(Spinner)findViewById(R.id.department);
        machine=(Spinner)findViewById(R.id.machine);
        task=(Spinner)findViewById(R.id.task);
        prof=(Spinner)findViewById(R.id.prof);
        gobaacktohomefordailog=(Button)findViewById(R.id.goback);

        back=(Button)findViewById(R.id.back);
        createalertbutton=(Button)findViewById(R.id.createalertbutton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sectionlist, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        section.setAdapter(adapter);

        //selected section will display particular line

        section.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if((section.getSelectedItem().toString()).equals("A"))
                {
                    ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(createalert.this, R.array.lineA, android.R.layout.simple_spinner_dropdown_item);
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    line.setAdapter(adapter1);

                }

                else if ((section.getSelectedItem().toString()).equals("B"))
                {
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(createalert.this, R.array.lineB, android.R.layout.simple_spinner_dropdown_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    line.setAdapter(adapter2);
                }

                else if((section.getSelectedItem().toString()).equals("--blank--"))
                {
                    Toast.makeText(createalert.this, "Select Section for Line", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(createalert.this, R.array.lineC, android.R.layout.simple_spinner_dropdown_item);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    line.setAdapter(adapter3);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //profile
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.profilelist, android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profile.setAdapter(adapter4);

        //department
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.departmentlist, android.R.layout.simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        depart.setAdapter(adapter5);

        //task selection

        depart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if((depart.getSelectedItem().toString()).equals("Maintance"))
                {
                    ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(createalert.this, R.array.Maintance, android.R.layout.simple_spinner_dropdown_item);
                    adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    task.setAdapter(adapter6);

                }
                else if ((depart.getSelectedItem().toString()).equals("Feeding Helpers"))
                {
                    ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(createalert.this, R.array.FeedingHelpers, android.R.layout.simple_spinner_dropdown_item);
                    adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    task.setAdapter(adapter7);
                }
                else if(((depart.getSelectedItem().toString())).equals("HR"))
                {
                    ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(createalert.this, R.array.HR, android.R.layout.simple_spinner_dropdown_item);
                    adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    task.setAdapter(adapter8);
                }
                else if(((depart.getSelectedItem().toString()).equals("Quality")))
                {
                    ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(createalert.this, R.array.Quality, android.R.layout.simple_spinner_dropdown_item);
                    adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    task.setAdapter(adapter9);
                }
                else if((depart.getSelectedItem().toString()).equals("IE"))
                {
                    ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(createalert.this, R.array.IE, android.R.layout.simple_spinner_dropdown_item);
                    adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    task.setAdapter(adapter10);
                }
                else {
                    Toast.makeText(createalert.this, "Please Select the Department", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });










        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.profilelist, android.R.layout.simple_spinner_dropdown_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prof.setAdapter(adapter11);


        createalertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addNotification();

                final Dialog d=new Dialog(createalert.this);
                d.setContentView(R.layout.alertcreateddailog);
                d.setTitle("--Alert--");
                d.setCanceledOnTouchOutside(false);
                d.show();







            }
        });


        gobaacktohomefordailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(createalert.this,home.class);
                startActivity(i);
            }
        });





                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(createalert.this, home.class);
                        startActivity(i);
                    }
                });






































    }






    private void addNotification()
    {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("Notification Example");
        builder.setContentText("ALERT");

     /*   Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound()

        */




        Intent noti=new Intent(this, Alert.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this, 0,noti,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());


    }







}

