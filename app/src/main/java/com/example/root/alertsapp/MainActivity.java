package com.example.root.alertsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText empid,pswd;
    Button login;
    DatabaseHelper db;
    String email,password;


    String idpass[][]={{"GIEHEAD","Aquarelle1"},{"FMANAGER","Aquarelle2"},{"PMANAGER","Aquarelle3"},{"IEE","Aquarelle4"},{"IELE","Aquarelle5"},{"HRMANAGER","Aquarelle6"},{"WEOF","Aquarelle7"},{"RQH","Aquarelle8"},{"QAM","Aquarelle9"},{"RMH","Aquarelle10"},{"MI","Aquarelle11"},{"S","tAquarelle12"},
            {"S2","Aquarelle13"},{"S3","Aquarelle14"},{"S4","Aquarelle15"},{"S5","Aquarelle16"},{"QC1","Aquarelle17"},{"QC2","Aquarelle18"},
            {"QC3","Aquarelle19"},{"QC4","Aquarelle20"},{"QC5","Aquarelle21"},{"LI1","Aquarelle22"},{"LI2","Aquarelle23"},{"LI3","Aquarelle24"},
            {"LI4","Aquarelle25"},{"LI5","Aquarelle26"},{"IE1","Aquarelle27"},{"IE2","Aquarelle28"},{"IE3","Aquarelle29"},
            {"IE4","Aquarelle30"},{"IE5","Aquarelle31"},{"M1","Aquarelle32"},{"M2","Aquarelle33"},{"M3","Aquarelle34"},
            {"M4","Aquarelle35"},{"M5","Aquarelle36"},{"FH1","Aquarelle37"},{"FH2","Aquarelle38"},{"FH3","Aquarelle39"},
            {"FH4","Aquarelle40"},{"FH5","Aquarelle41"},{"TO1","Aquarelle42"},{"TO2","Aquarelle43"},{"TO3","Aquarelle44"},
            {"TO4","Aquarelle45"},{"TO5","Aquarelle46"},{"CM","Aquarelle47"},{"TS1","Aquarelle53"},
            {"TS2","Aquarelle54"}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db=new DatabaseHelper(this);

        empid=(EditText)findViewById(R.id.empid);

        pswd=(EditText)findViewById(R.id.pswd);
        login=(Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=empid.getText().toString();
                password=pswd.getText().toString();
              Boolean chkemailpass=db.emailpassword(email,password);
            //    if (chkemailpass==true)
              //      Toast.makeText(getApplicationContext(),"Login Sucessfully",Toast.LENGTH_SHORT).show();
               // else
                 //   Toast.makeText(getApplicationContext(),"Worng Email and Password",Toast.LENGTH_SHORT).show();

            }
        });






    }
}
