package com.hungrok.mycomponents;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    MyResultReceiver myreceiver ;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_activity:
                    doActivity() ;
                    return true;
                case R.id.nav_service:
                    doService() ;
                    return true;
                case R.id.nav_br:
                    doBroadcastReceiver() ;
                    return true;
                case R.id.nav_cp:
                    doContentProvider() ;
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    protected void doActivity(){
        Intent actit= new Intent(this, Sub1Activity.class) ;
        startActivityForResult(actit, 1); ;
    }
    protected void doService(){ // Only explicit intent
        Intent svcit= new Intent(this, MyService.class) ;
        myreceiver = new MyResultReceiver(new Handler()) ;
        myreceiver.setReceiver(new MyResultReceiver.Receiver(){
            @Override
            public void onReceiveResult(int resultCode, Bundle resultData){
                System.out.printf("MyResultReceiver, code=%d \n",resultCode) ;
            }
        });
        svcit.putExtra("receiver",myreceiver) ;
        startService(svcit) ;
    }
    protected void doBroadcastReceiver(){

        //Intent brit = new Intent(this, MyReceiver.class) ;
        //sendBroadcast(brit);
        /*
         brit.setAction() ;
         brit.setData() ;
         brit.setClass() ;
         brit.setFlags() ;
         brit.addCategory() ;
         brit.addFlags()
         brit.putExtra("POWER", 20) ;
         brit.putExtra("NAME","HR KWON") ;



         */

        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this) ;
        IntentFilter lbmif = new IntentFilter("MYMSG1") ;
        lbm.registerReceiver(new MyReceiver(), lbmif);
        Intent lbmit = new Intent("MYMSG1") ;
        lbm.sendBroadcast(lbmit);

    }
    protected void doContentProvider(){ // practice with shared preference


        Uri contentUri = Uri.parse("content://com.hungrok.mycomponents/MyContentProvider");
        ContentResolver cr = getContentResolver() ;
        cr.update(contentUri, null,null,null) ;

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        System.out.printf("onActivityResult, code=%d \n",resultCode) ;
    }
}

class MyResultReceiver extends ResultReceiver{

    private Receiver receiver ;
    public MyResultReceiver (Handler handler){
        super(handler) ;
    }

    public void setReceiver(Receiver receiver){
        this.receiver = receiver ;
    }

    public interface Receiver{
        public void onReceiveResult(int resultCode, Bundle resultData) ;
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData){
        receiver.onReceiveResult(resultCode,resultData );
    }

}