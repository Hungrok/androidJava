package com.hungrok.mycomponents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Sub1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);


        Button bt1 = findViewById(R.id.button1); // phone call
        Button bt2 = findViewById(R.id.button2); // web
        Button bt3 = findViewById(R.id.button3); // email
        Button bt4 = findViewById(R.id.button4); // message
        Button bt5 = findViewById(R.id.button5); // alarm
        Button bt6 = findViewById(R.id.button6); // contact


        View.OnClickListener ls1 = new View.OnClickListener() { // phone call
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + "0312045693");
                Intent it1 = new Intent(Intent.ACTION_DIAL, uri);
                if (it1.resolveActivity(getPackageManager()) != null)
                    startActivity(it1);
            }
        };
        View.OnClickListener ls2 = new View.OnClickListener() { // web page
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("www.daum.net");
                Intent it1 = new Intent(Intent.ACTION_VIEW,uri);
                if (it1.resolveActivity(getPackageManager()) != null)
                    startActivity(it1);
            }
        };
        View.OnClickListener ls3 = new View.OnClickListener() { // email
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("mailto:");

                Intent it1 = new Intent(Intent.ACTION_SENDTO, uri);
                it1.putExtra(Intent.EXTRA_EMAIL, "hungrok@hanmail.net") ;
                it1.putExtra(Intent.EXTRA_SUBJECT, "Hello for android app") ;
                if (it1.resolveActivity(getPackageManager()) != null)
                    startActivity(it1);
            }
        };
        View.OnClickListener ls4 = new View.OnClickListener() { // message
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + "0312045693");
                Intent it1 = new Intent(Intent.ACTION_SENDTO) ;
                it1.setType("text/plain") ;
                it1.putExtra("sms_body", "Hello from android") ;
                if (it1.resolveActivity(getPackageManager()) != null)
                    startActivity(it1);
            }
        };
        View.OnClickListener ls5 = new View.OnClickListener() { // alarm
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(AlarmClock.ACTION_SET_ALARM);
                it1.putExtra(AlarmClock.EXTRA_MESSAGE, "Test by KHR") ;
                it1.putExtra(AlarmClock.EXTRA_HOUR, 12) ;
                it1.putExtra(AlarmClock.EXTRA_MINUTES, 30) ;
                if (it1.resolveActivity(getPackageManager()) != null)
                    startActivity(it1);
            }
        };
        View.OnClickListener ls6 = new View.OnClickListener() { // contact
            @Override
            public void onClick(View v) {

                Intent it1 = new Intent(Intent.ACTION_PICK) ;
                it1.setType(ContactsContract.Contacts.CONTENT_TYPE) ;
                if (it1.resolveActivity(getPackageManager()) != null)
                    startActivity(it1);

                /* For IPC test */
                setResult(1);
                finish() ;
            }
        };

        bt1.setOnClickListener(ls1);
        bt2.setOnClickListener(ls2);
        bt3.setOnClickListener(ls3);
        bt4.setOnClickListener(ls4);
        bt5.setOnClickListener(ls5);
        bt6.setOnClickListener(ls6);




    };

}
