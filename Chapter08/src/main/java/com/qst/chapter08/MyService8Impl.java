package com.qst.chapter08;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService8Impl extends Service {

    private final MyService8.Stub binder = new MyService8.Stub() {

        public int sum(int a, int b) throws RemoteException {
            Log.i("MyService8Impl", "sum(" + a + ", " + b + ")");
            return a + b;
        }
    };

    @Override
    public void onCreate() {
        Log.i("MyService8Impl", "onCreate()");
    }

    @Override
    public IBinder onBind(Intent arg0) {;;
        Log.i("MyService8Impl", "onBind()");
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("MyService8Impl", "onUnbind()");
        return false;
    }

    @Override
    public void onDestroy() {
        Log.i("MyService8Impl", "onDestroy()");
    }
}