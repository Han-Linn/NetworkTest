package com.qst.chapter06;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Adminstrator on 2016/10/8.
 */
public class AddMusicActivity extends AppCompatActivity {
    private EditText et1,et2;
    private Button b1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        this.setTitle("添加收藏信息");

        et1= (EditText) findViewById(R.id.EditTextName);
        et2= (EditText) findViewById(R.id.EditTextSinger);
        b1= (Button) findViewById(R.id.ButtonAdd);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取用户输入的文本信息
                String name=et1.getText().toString();
                String singer=et2.getText().toString();
                //创建ContentValues对象，封装记录信息
                ContentValues values=new ContentValues();
                values.put("name",name);
                values.put("singer",singer);

                //创建数据库工具类DBHelper
                DBHelper helper=new DBHelper(getApplicationContext());
                //调用insert()方法插入数据
                helper.insert(values);
                //跳转到QueryActivity，显示音乐列表
                Intent intent=new Intent(AddMusicActivity.this,QueryActivity.class);
                startActivity(intent);
            }
        });
    }
}
