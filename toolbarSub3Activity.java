package com.hungrok.toolbar;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class Sub3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_email_black_24dp);
        setSupportActionBar(toolbar);
        ActionBar ab1 = getSupportActionBar();
        ab1.setTitle("MyToolbar4");
        // Up navigation
        ab1.setDisplayHomeAsUpEnabled(true);
        ab1.setHomeButtonEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id==android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        if (id == R.id.app_bar_search) {
            // SearchView
        }
        if (id == R.id.app_bar_airplane){
            doAirplane() ;
        }
        if (super.onOptionsItemSelected(item)) return true;
        else return false;


    }

    protected void doAirplane(){
        //Intent it1 = new Intent(this, TabActivity.class) ;
        //startActivity(it1) ;
    }
}
