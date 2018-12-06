package com.qst.chapter09;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Adminstrator on 2016/10/24.
 */

public class MyApplication extends Application {
    // 建立请求队列
    public static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getHttpQueue() {
        return queue;
    }
}
