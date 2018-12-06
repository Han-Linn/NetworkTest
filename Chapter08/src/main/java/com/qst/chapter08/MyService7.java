package com.qst.chapter08;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyService7 extends IntentService {

    public MyService7() {
        super("IntentService测试");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MyService7", "onStartCommand：startId=" + startId);
        intent.putExtra("startId", startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("MyService7", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int startId = intent.getIntExtra("startId", 0);
        Log.i("MyService7", "任务" + startId + "开始运行");

        for (int i = 0; i < 5; i++) {
            Log.i("MyService7", "任务" + startId + "正在运行：" + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }

        Log.i("MyService7", "任务" + startId + "运行结束");
    }

}
