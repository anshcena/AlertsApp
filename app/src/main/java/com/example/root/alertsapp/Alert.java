package com.example.root.alertsapp;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

public class Alert extends AppCompatActivity {

    Button acceptbutton,notaccepted;
    int Flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        acceptbutton=(Button)findViewById(R.id.acceptbutton);
        notaccepted=(Button)findViewById(R.id.notattended);

        acceptbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            new SENDSTATUS().execute();
            Flag=2;
            }
        });

        notaccepted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SENDSTATUS().execute();
                Flag=0;
            }
        });



    }



    public class SENDSTATUS extends AsyncTask<String, Void, Bitmap> {
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
                String postReceiverUrl = "http://192.168.1.223:8000/api/login/";
                Log.v(TAG, "postURL: " + postReceiverUrl);


                HttpClient c = new DefaultHttpClient();

// post header
                HttpPost h = new HttpPost(postReceiverUrl);

// add your data


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);


                if(Flag==1)
                nameValuePairs.add(new BasicNameValuePair("status","Ongoing" ));
                else
                    nameValuePairs.add(new BasicNameValuePair("status","Notattended" ));


                nameValuePairs.add(new BasicNameValuePair("loggeduser",loggeduser));


                h.setEntity(new UrlEncodedFormEntity(nameValuePairs));

// execute HTTP post request
                HttpResponse response = c.execute(h);
                HttpEntity resEntity = response.getEntity();

                if (resEntity != null) {

                    String responseStr = EntityUtils.toString(resEntity).trim();
                    Log.v(TAG, "Response: " + responseStr);

                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }





}
