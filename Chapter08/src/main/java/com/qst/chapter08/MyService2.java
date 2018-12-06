package com.qst.chapter08;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService2 extends Service {
    
    @Override
    public void onCreate() {
        Log.i("MyService2", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MyService2", "onStartCommand" + this);

        final String message = intent.getStringExtra("message");
        Log.i("MyService2", "intent:" + message + ",flags:" + flags
                + ",startId:" + startId);

         try {
         Thread.sleep(20000);
         } catch (InterruptedException e) {
         e.printStackTrace();
         }

         stopSelf();
         stopSelfResult(startId);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("MyService2", "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
