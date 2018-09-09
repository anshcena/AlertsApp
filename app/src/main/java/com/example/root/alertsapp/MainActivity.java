package com.example.root.alertsapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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




public class MainActivity extends AppCompatActivity {

    public static String loggeduser="";
    public static String url = "http://192.168.1.226:8000/api/";
    private static final String TAG = "MainActivity.java";

    EditText empid, pswd;
    Button login;
    String email,password;


  /* String idpass[][]={{"GIEHEAD","Aquarelle1"},{"FMANAGER","Aquarelle2"},{"PMANAGER","Aquarelle3"},{"IEE","Aquarelle4"},{"IELE","Aquarelle5"},{"HRMANAGER","Aquarelle6"},{"WEOF","Aquarelle7"},{"RQH","Aquarelle8"},{"QAM","Aquarelle9"},{"RMH","Aquarelle10"},{"MI","Aquarelle11"},{"S","tAquarelle12"},
            {"S2","Aquarelle13"},{"S3","Aquarelle14"},{"S4","Aquarelle15"},{"S5","Aquarelle16"},{"QC1","Aquarelle17"},{"QC2","Aquarelle18"},
            {"QC3","Aquarelle19"},{"QC4","Aquarelle20"},{"QC5","Aquarelle21"},{"LI1","Aquarelle22"},{"LI2","Aquarelle23"},{"LI3","Aquarelle24"},
            {"LI4","Aquarelle25"},{"LI5","Aquarelle26"},{"IE1","Aquarelle27"},{"IE2","Aquarelle28"},{"IE3","Aquarelle29"},
            {"IE4","Aquarelle30"},{"IE5","Aquarelle31"},{"M1","Aquarelle32"},{"M2","Aquarelle33"},{"M3","Aquarelle34"},
            {"M4","Aquarelle35"},{"M5","Aquarelle36"},{"FH1","Aquarelle37"},{"FH2","Aquarelle38"},{"FH3","Aquarelle39"},
            {"FH4","Aquarelle40"},{"FH5","Aquarelle41"},{"TO1","Aquarelle42"},{"TO2","Aquarelle43"},{"TO3","Aquarelle44"},
            {"TO4","Aquarelle45"},{"TO5","Aquarelle46"},{"CM","Aquarelle47"},{"TS1","Aquarelle53"},
            {"TS2","Aquarelle54"}};
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);













        empid = (EditText) findViewById(R.id.empid);

        pswd = (EditText) findViewById(R.id.pswd);
        login = (Button) findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=empid.getText().toString();
                password=pswd.getText().toString();
            new Mydownloader().execute();

                            }

        });

    }

    private class Mydownloader extends AsyncTask<String, Void, Bitmap> {
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
                String postReceiverUrl = url + "login/";
                Log.v(TAG, "postURL: " + postReceiverUrl);


                HttpClient c = new DefaultHttpClient();

// post header
                HttpPost h = new HttpPost(postReceiverUrl);

// add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);

                nameValuePairs.add(new BasicNameValuePair("username", ""+email));
                nameValuePairs.add(new BasicNameValuePair("password", ""+password));
                nameValuePairs.add(new BasicNameValuePair("state","1"));

                h.setEntity(new UrlEncodedFormEntity(nameValuePairs));

// execute HTTP post request
                HttpResponse response = c.execute(h);
                HttpEntity resEntity = response.getEntity();

                if (resEntity != null) {

                    String responseStr = EntityUtils.toString(resEntity).trim();
                    Log.v(TAG, "Response: " + responseStr);

                    if(responseStr.equals("1"))
                    {
                   //     Toast.makeText(MainActivity.this, "WELCOME", Toast.LENGTH_SHORT).show();

                        Intent iii = new Intent(MainActivity.this, home.class);
                        loggeduser=email;
                        iii.putExtra("username",email);
                        startActivity(iii);
                    }




                    // you can add an if statement here and do other actions based on the response
                }



              /*  else {

                    Toast.makeText(MainActivity.this, "AGAIN", Toast.LENGTH_SHORT).show();
                }*/


            }
            catch (ClientProtocolException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }




            return null;
        }
    }


}