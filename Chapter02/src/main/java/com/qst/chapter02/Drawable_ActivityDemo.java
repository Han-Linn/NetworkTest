package com.qst.chapter02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Drawable_ActivityDemo extends AppCompatActivity {
    TextView fl;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_layout);
        fl= (TextView) findViewById(R.id.tv10);
        fl.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgimg1));

    }
}
