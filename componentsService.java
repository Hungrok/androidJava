package com.hungrok.mycomponents;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        System.out.printf("MyService onBind \n") ;
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        System.out.printf("MyService onCreate \n") ;
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.printf("MyService onStartCommand \n") ;
        ResultReceiver receiver = intent.getParcelableExtra("receiver") ;
        Bundle bundle = new Bundle() ;
        bundle.putString("resultValue","TestOkay") ;
        receiver.send(Activity.RESULT_OK,bundle) ;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.printf("MyService onDestroy \n") ;
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.printf("MyService onUnbind \n") ;
        return super.onUnbind(intent);
    }

}
