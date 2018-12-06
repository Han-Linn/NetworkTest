package com.qst.chapter02;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Adminstrator on 2016/10/25.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
