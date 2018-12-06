package com.qst.chapter02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Adminstrator on 2016/8/22.
 */
public class ActivityTest extends AppCompatActivity {
    private static final String TAG="ActivityTest";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"执行了onCreate()方法");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"执行了onStart()方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"执行了onRestart()方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"执行了onResume()方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"执行了onStop()方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"执行了onDestroy()方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"执行了onPause()方法");
    }
}
