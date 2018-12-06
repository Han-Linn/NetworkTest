package com.qst.chapter08;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService3 extends Service {
    private MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        Log.i("MyService3", "onCreate");
    }

    @Override
    public void onDestroy() {
        Log.i("MyService3", "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("MyService3", "onBind");

        final String message = intent.getStringExtra("message");
        Log.i("MyService3", "intent:" + message);

        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("MyService3", "onUnbind");
        return false;
    }

    public String doSomeOperation(String param) {
        Log.i("MyService3", "doSomeOperation: param=" + param);
        return "return value";
    }

    public class MyBinder extends Binder {
        public MyService3 getService() {
            return MyService3.this;
        }
    }
}
