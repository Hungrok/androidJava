package com.hungrok.mycomponents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        System.out.printf("BroadcastReceiver onReceive, instance=%s \n",this.toString()) ;

        /*
        String action = intent.getAction();
        intent.getStringExtra("text");
        getAction() ;
        getData() ;
        getStringExtra() ;
        getClass() ;
        getCategories() ;
        */

    }
}
