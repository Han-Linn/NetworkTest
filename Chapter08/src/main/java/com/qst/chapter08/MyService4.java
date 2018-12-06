package com.qst.chapter08;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService4 extends Service {
    private MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        Log.i("MyService4", "onCreate");
    }

    @Override
    public void onDestroy() {
        Log.i("MyService4", "onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MyService4", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("MyService4", "onBind");
        return myBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i("MyService4", "onRebind");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("MyService4", "onUnbind");
        return true;
    }

    public class MyBinder extends Binder {
    }
}
