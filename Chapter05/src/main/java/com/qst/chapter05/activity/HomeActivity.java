package com.qst.chapter05.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.qst.chapter05.R;

public class HomeActivity extends AppCompatActivity {
    Button homeButton;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //初始化
        homeButton= (Button) findViewById(R.id.homeBtn);
        //注册事件
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建Intent 对象
                Intent intent=new Intent();
                //为Intent设置Action和Category属性
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                //启动Activity
                startActivity(intent);
            }
        });
    }
}
