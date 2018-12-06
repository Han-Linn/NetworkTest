package com.qst.chapter02;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Dimen_ActivityDemo extends AppCompatActivity{
    TextView tv2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dimen_layout);
        tv2= (TextView) findViewById(R.id.tv2);
        tv2.setTextSize(getResources().getDimension(R.dimen.dimen_java));
    }
}
