package com.qst.chapter02;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
public class Style_ActivityDemo extends AppCompatActivity{
    TextView tv2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style_layout);
        tv2= (TextView) findViewById(R.id.tv4);
        tv2.setTextAppearance(this,R.style.red_textview);
}
}
