package com.qst.chapter02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Color_ActivityDemo extends AppCompatActivity {
    TextView tx4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_layout);
        tx4= (TextView) findViewById(R.id.tv4);
        tx4.setTextColor(getResources().getColor(R.color.color_java));
    }
}
