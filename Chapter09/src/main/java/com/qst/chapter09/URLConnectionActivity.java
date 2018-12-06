package com.qst.chapter09;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



/**
 * Created by Adminstrator on 2016/10/20.
 */
public class URLConnectionActivity extends AppCompatActivity{
    Button get,post;
    TextView show;
    //代表服务器响应的字符串
    String response;
    Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what ==0x123){
                //设置show组件显示服务期响应
                show.setText(response);
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        get= (Button) findViewById(R.id.get);
        post= (Button) findViewById(R.id.post);
        show=    (TextView) findViewById(R.id.show);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        response=GetPostUtil.sendGet("http://192.168.52.13:8080/index.jsp",null);
                        //发送消息通知UI线程更新UI组件
                        handler.sendEmptyMessage(0x123);
                    }
                }.start();
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        response=GetPostUtil.sendPost("http://192.168.52.13:8080/judgeUser.jsp","userName=abc&password=123");
                        //发送消息通知UI线程更新UI组件
                        handler.sendEmptyMessage(0x123);
                    }
                }.start();
            }
        });
    }
}
