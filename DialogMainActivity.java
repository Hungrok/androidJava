package com.hungrok.dialog;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements DialFragment1.OnFragmentInteractionListener,
                     DialFragment2.OnFragmentInteractionListener,
        DialFragment3.OnFragmentInteractionListener,
        DialFragment4.OnFragmentInteractionListener
{

    private FragmentManager fmanager ;
    private FragmentTransaction ftrx ;
    DialFragment1 dfm1 ;
    DialFragment2 dfm2 ;
    DialFragment3 dfm3 ;
    DialFragment4 dfm4 ;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_alert:
                    System.out.printf("onNavigationItemSelected-1 \n") ;
                    DialFragment1 df1 = (DialFragment1) fmanager.findFragmentByTag("FRAG1") ;
                    df1.show(fmanager,"FRAG1") ; // as NullPointException
                    //dfm1.show(fmanager,"FRAG1") ;
                    return true;
                case R.id.navigation_progress:
                    System.out.printf("onNavigationItemSelected-2 \n") ;
                    DialFragment2 df2 = (DialFragment2) fmanager.findFragmentByTag("FRAG2") ;
                    df2.show(fmanager,"FRAG2") ;
                    //dfm2.show(fmanager,"FRAG2") ;
                    return true;
                case R.id.navigation_datepicker:
                    System.out.printf("onNavigationItemSelected-3 \n") ;
                    DialFragment3 df3 = (DialFragment3) fmanager.findFragmentByTag("FRAG3") ;
                    df3.show(fmanager,"FRAG3") ;
                    //dfm3.show(fmanager,"FRAG3") ;

                    return true;
                case R.id.navigation_timepicker:
                    System.out.printf("onNavigationItemSelected-4 \n") ;
                    DialFragment4 df4 = (DialFragment4) fmanager.findFragmentByTag("FRAG4") ;
                    df4.show(fmanager,"FRAG4") ;
                    //dfm4.show(fmanager,"FRAG4") ;
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        View decoview = getWindow().getDecorView() ;

        View rootview = getLayoutInflater().from(this).inflate(R.layout.activity_main,null);
        setContentView(rootview);
        View rview2 = getWindow().getDecorView().getRootView() ;
        View rview3 = getWindow().getDecorView() ;
        View rview4 = rootview.getRootView() ;
        View rview5 = findViewById(R.id.container2) ;

        System.out.printf("rootview2 equals=%s \n",rootview.equals(rview2)) ;
        System.out.printf("rootview3 equals=%s \n",rootview.equals(rview3)) ;
        System.out.printf("rootview4 equals=%s \n",rootview.equals(rview4)) ;
        System.out.printf("rootview5 equals=%s \n",rootview.equals(rview5)) ;


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        /* Fragment setup into FragmentManager */
        fmanager = getSupportFragmentManager() ; // v4
        ftrx = fmanager.beginTransaction() ;
        dfm1 = DialFragment1.newInstance(1);
        dfm2 = DialFragment2.newInstance(2);
        dfm3 = DialFragment3.newInstance(3);
        dfm4 = DialFragment4.newInstance(4);
        ftrx.add(dfm1,"FRAG1") ;
        ftrx.add(dfm2,"FRAG2") ;
        ftrx.add(dfm3,"FRAG3") ;
        ftrx.add(dfm4,"FRAG4") ;
        //ftrx.addToBackStack("FRAG4");
        ftrx.commit() ;
        //fmanager.executePendingTransactions(); // this affects...
        ftrx.addToBackStack("FRAG4");

        DialFragment4 dfm4a = (DialFragment4) fmanager.findFragmentByTag("FRAG4") ;
        System.out.printf("Same fragment=%s \n",dfm4.equals(dfm4a)) ; // false as null object



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}


