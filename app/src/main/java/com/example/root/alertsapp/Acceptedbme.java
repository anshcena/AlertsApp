package com.example.root.alertsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.root.alertsapp.MainActivity.loggeduser;
import static com.example.root.alertsapp.MainActivity.url;

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


        new dd().execute();

    }

    private class dd extends AsyncTask<String, Void, Bitmap> {
        private static final String TAG ="";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ProgressDialog pDialog = new ProgressDialog(Acceptedbme.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
           /* if (pDialog.isShowing())
                pDialog.dismiss();
        */}

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                // url where the data will be posted
                String postReceiverUrl = url + "getAlert/";
                Log.v(TAG, "postURL: " + postReceiverUrl);


                HttpClient client = new DefaultHttpClient();

// post header
                HttpPost post = new HttpPost(postReceiverUrl);

// add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);

                nameValuePairs.add(new BasicNameValuePair("username", loggeduser.toString()));

                post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

// execute HTTP post request
                Log.v(TAG, "Response: 3");
                HttpResponse response = client.execute(post);
                Log.v(TAG, "Response: 1");
                HttpEntity resEntity = response.getEntity();
                Log.v(TAG, "Response: 2");

                if (resEntity != null) {

                    String responseStr = EntityUtils.toString(resEntity).trim();
                    Log.v(TAG, "Response: " + responseStr);



                }



            }
            catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (ConnectTimeoutException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }

}
