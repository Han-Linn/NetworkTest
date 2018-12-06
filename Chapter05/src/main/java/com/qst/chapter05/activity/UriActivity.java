package com.qst.chapter05.activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.qst.chapter05.R;

/**
* 结合Data属性和Action属性打开指定的网页
*/
public class UriActivity extends AppCompatActivity{
    Button uriBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri);
        uriBtn= (Button) findViewById(R.id.uriBtn);
        uriBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //打开网页
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri data =Uri.parse("http://www.baidu.com");
                //利用Data属性
                intent.setData(data);
                startActivity(intent);
            }
        });
    }
}
