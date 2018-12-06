package com.qst.chapter02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Strings_ActivityDemo extends AppCompatActivity {

    TextView tv2;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.strings_layout);
        tv2= (TextView) findViewById(R.id.tv2);
        tv2.setText(R.string.app_class);

    }
}
