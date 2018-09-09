package com.example.root.alertsapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

import static com.example.root.alertsapp.MainActivity.url;

public class home extends AppCompatActivity {


    Button createalert1,myalert,allalerts;
    TextView logout;
    String activeuser="";
    private static final String TAG = "home.java";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        createalert1=(Button)findViewById(R.id.createalert);
        myalert=(Button)findViewById(R.id.myalert);
        allalerts=(Button)findViewById(R.id.allalert1);

        logout=(TextView)findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new logouttohome().execute();

            }
        });

        createalert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(home.this,createalert.class);
                startActivity(ii);
            }
        });

        myalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(home.this,Myalerts.class);
                startActivity(intent);

            }
        });

        allalerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(home.this,Allalertss.class);
                startActivity(ii);
            }
        });


    }


    private class logouttohome extends AsyncTask<String, Void, Bitmap> {
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
                String postReceiverUrl = url + "logout/";
                Log.v(TAG, "postURL: " + postReceiverUrl);

                Bundle bundle=getIntent().getExtras();
                activeuser=bundle.getString("username");
                HttpClient c = new DefaultHttpClient();

// post header
                HttpPost h = new HttpPost(postReceiverUrl);

// add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);

                nameValuePairs.add(new BasicNameValuePair("username", ""+activeuser));

                h.setEntity(new UrlEncodedFormEntity(nameValuePairs));

// execute HTTP post request
                HttpResponse response = c.execute(h);



                Intent i=new Intent(home.this,MainActivity.class);
                startActivity(i);

                HttpEntity resEntity = response.getEntity();

                if (resEntity != null) {

                    String responseStr = EntityUtils.toString(resEntity).trim();
                    Log.v(TAG, "Response: " + responseStr);

                          }

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


    @Override
    public void onBackPressed() {
      //  super.onBackPressed();
    }
}
