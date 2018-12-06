package com.qst.chapter08;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

// 一个空的Service示例
public class MyService1 extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
