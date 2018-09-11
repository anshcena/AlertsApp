package com.example.root.alertsapp;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.pusher.pushnotifications.PushNotifications;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.root.alertsapp.MainActivity.loggeduser;
import static com.example.root.alertsapp.MainActivity.url;


public class createalert extends AppCompatActivity {

    private static final String TAG = "";
    Spinner section, line, profile, depart, machine, task, prof;
    Button back, createalertbutton;// gobaacktohomefordailog;

    String linetoserver="",profiletoserver="",deptoser,protoser,tasktoser,sectoser;

    int lineflag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createalert);


        section = (Spinner) findViewById(R.id.spinner);
        line = (Spinner) findViewById(R.id.line);
        profile = (Spinner) findViewById(R.id.profile);
        depart = (Spinner) findViewById(R.id.department);
        machine = (Spinner) findViewById(R.id.machine);
        task = (Spinner) findViewById(R.id.task);
        prof = (Spinner) findViewById(R.id.prof);
      //  gobaacktohomefordailog = (Button) findViewById(R.id.goback);

        back = (Button) findViewById(R.id.back);
        createalertbutton = (Button) findViewById(R.id.createalertbutton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sectionlist, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        section.setAdapter(adapter);

        //selected section will display particular line

        section.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                sectoser=section.getSelectedItem().toString();
                if ((section.getSelectedItem().toString()).equals("A")) {
                    ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(createalert.this, R.array.lineA, android.R.layout.simple_spinner_dropdown_item);
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    line.setAdapter(adapter1);

                } else if ((section.getSelectedItem().toString()).equals("B")) {
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(createalert.this, R.array.lineB, android.R.layout.simple_spinner_dropdown_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    line.setAdapter(adapter2);
                } else if ((section.getSelectedItem().toString()).equals("--blank--")) {
                    Toast.makeText(createalert.this, "Select Section for Line", Toast.LENGTH_SHORT).show();
                } else {
                    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(createalert.this, R.array.lineC, android.R.layout.simple_spinner_dropdown_item);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    line.setAdapter(adapter3);

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        line.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   linetoserver= line.getSelectedItem().toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        task.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tasktoser=task.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        //profile


        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.profilelist, android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profile.setAdapter(adapter4);

        profile.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              profiletoserver=profile.getOnItemSelectedListener().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //department
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.departmentlist, android.R.layout.simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        depart.setAdapter(adapter5);

        //task selection

        depart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if ((depart.getSelectedItem().toString()).equals("Maintance")) {
                    ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(createalert.this, R.array.Maintance, android.R.layout.simple_spinner_dropdown_item);
                    adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    task.setAdapter(adapter6);


                } else if ((depart.getSelectedItem().toString()).equals("Feeding Helpers")) {
                    ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(createalert.this, R.array.FeedingHelpers, android.R.layout.simple_spinner_dropdown_item);
                    adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    task.setAdapter(adapter7);
                } else if (((depart.getSelectedItem().toString())).equals("HR")) {
                    ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(createalert.this, R.array.HR, android.R.layout.simple_spinner_dropdown_item);
                    adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    task.setAdapter(adapter8);
                } else if (((depart.getSelectedItem().toString()).equals("Quality"))) {
                    ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(createalert.this, R.array.Quality, android.R.layout.simple_spinner_dropdown_item);
                    adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    task.setAdapter(adapter9);
                } else if ((depart.getSelectedItem().toString()).equals("IE")) {
                    ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(createalert.this, R.array.IE, android.R.layout.simple_spinner_dropdown_item);
                    adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    task.setAdapter(adapter10);
                } else {
                    Toast.makeText(createalert.this, "Please Select the Department", Toast.LENGTH_SHORT).show();
                }
                deptoser = depart.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.profilelist, android.R.layout.simple_spinner_dropdown_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prof.setAdapter(adapter11);

        prof.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                protoser=prof.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(createalert.this, home.class);
                startActivity(i);
            }
        });


        createalertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  addNotification();



                final Dialog d = new Dialog(createalert.this);
                d.setContentView(R.layout.alertcreateddailog);
                d.setTitle("--Alert--");
                d.setCanceledOnTouchOutside(false);
                d.show();

                new pushtoserver().execute();







             /*   gobaacktohomefordailog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(createalert.this,home.class);
                        startActivity(i);
                    }
                });*/


            }
        });


    }


    private void addNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("Notification Example");
        builder.setContentText("ALERT");


        Intent noti = new Intent(this, Alert.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, noti, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());


    }


    public class pushtoserver extends AsyncTask<String, Void, Bitmap> {
        private static final String TAG = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                // url where the data will be posted
                String postReceiverUrl = url +"createAlert/";
                Log.v(TAG, "postURL: " + postReceiverUrl);


                HttpClient c = new DefaultHttpClient();

// post header
                HttpPost h = new HttpPost(postReceiverUrl);

// add your data


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(6);
                nameValuePairs.add(new BasicNameValuePair("section", sectoser));
                nameValuePairs.add(new BasicNameValuePair("line", linetoserver));
                nameValuePairs.add(new BasicNameValuePair("profile", loggeduser));
                nameValuePairs.add(new BasicNameValuePair("department", deptoser));
                nameValuePairs.add(new BasicNameValuePair("profiletosend",protoser ));
                nameValuePairs.add(new BasicNameValuePair("tasktoserver", tasktoser));


                h.setEntity(new UrlEncodedFormEntity(nameValuePairs));

// execute HTTP post request
                HttpResponse response = c.execute(h);
                HttpEntity resEntity = response.getEntity();

                if (resEntity != null) {

                    String responseStr = EntityUtils.toString(resEntity).trim();
                    Log.v(TAG, "Response: " + responseStr);

                    if (responseStr == "1")
                    {
                        PushNotifications.start(getApplicationContext(), "502a2eb7-7efe-4d30-a15a-a645f3ff15db");
                        PushNotifications.subscribe("ALERT FOR YOU");


                    }
                    else{
//                        Toast.makeText(createalert.this, "Error!!! Submit again.-0", Toast.LENGTH_SHORT).show();
                    }


                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(createalert.this,home.class);
        startActivity(intent);
        //  super.onBackPressed();
    }
}