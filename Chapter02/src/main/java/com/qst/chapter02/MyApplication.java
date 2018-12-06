package com.qst.chapter02;

import android.app.Application;

/**
 * Created by Adminstrator on 2016/8/22.
 */
public class MyApplication extends Application{
    private String name;
    @Override
    public void onCreate() {
        super.onCreate();
        setName("北京");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
