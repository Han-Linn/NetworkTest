package com.qst.chapter08;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService6 extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        Log.i("MyService6", "onStartCommand：startId=" + startId);
        new Thread() {
            public void run() {
                Log.i("MyService6", "任务" + startId + "开始运行");

                for (int i = 0; i < 5; i++) {
                    Log.i("MyService6", "任务" + startId + "正在运行：" + i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                }

                Log.i("MyService6", "任务" + startId + "运行结束");
            }
        }.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("MyService6", "onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
