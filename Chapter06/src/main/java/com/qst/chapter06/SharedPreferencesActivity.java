package com.qst.chapter06;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Adminstrator on 2016/10/8.
 */
public class SharedPreferencesActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        //获取SharedPreferences对象
        preferences=getSharedPreferences("qstPreferences", Context.MODE_PRIVATE);
        editor=preferences.edit();
        Button read= (Button) findViewById(R.id.btnReader);
        Button write= (Button) findViewById(R.id.btnWriter);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //读取字符串数据
                String time=preferences.getString("time",null);
                //读取int类型的数据
                int randNum=preferences.getInt("random",0);
                String result=time==null ? "您暂时还未写入数据" :"写入时间为："+"\n"+time+"\n上次生成的随机数为："+ randNum;
                //使用Toast提示信息
                Toast.makeText(SharedPreferencesActivity.this,result,Toast.LENGTH_SHORT).show();
            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh：mm：ss");
                //存入当前时间
                editor.putString("time",sdf.format(new Date()));
                //存入一个随机数
                editor.putInt("random", (int) (Math.random()*100));
                //提交所有存入的数据
                editor.commit();
            }
        });
    }
}
