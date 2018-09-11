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
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.List;

import static com.example.root.alertsapp.MainActivity.loggeduser;
import static com.example.root.alertsapp.MainActivity.url;

public class Createdbme extends AppCompatActivity {

    TextView back1;
    TextView tn1, tn2, tn3, t1, t2, t3, s1, s2, s3, rs1, rs2, rs3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createdbme);
        back1 = (TextView) findViewById(R.id.backtomyalerts1);

        tn1 = (TextView) findViewById(R.id.textView44);
        tn2 = (TextView) findViewById(R.id.textView49);
        tn3 = (TextView) findViewById(R.id.textView53);

        t1 = (TextView) findViewById(R.id.textView45);
        t2 = (TextView) findViewById(R.id.textView50);
        t3 = (TextView) findViewById(R.id.textView54);

        s1 = (TextView) findViewById(R.id.textView48);
        s2 = (TextView) findViewById(R.id.textView51);
        s3 = (TextView) findViewById(R.id.textView55);

        rs1 = (TextView) findViewById(R.id.textView52);
        rs2 = (TextView) findViewById(R.id.textView56);
        rs3 = (TextView) findViewById(R.id.textView57);

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Createdbme.this, Myalerts.class);
                startActivity(intent);
            }
        });

        //calling http for display of data

        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

        new dd().execute();



    }


    private class dd extends AsyncTask<String, Void, Bitmap> {
        private static final String TAG ="";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ProgressDialog pDialog = new ProgressDialog(Createdbme.this);
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
