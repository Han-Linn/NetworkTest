package com.qst.chapter04.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.qst.chapter04.R;

public class ListViewDemoActivity extends AppCompatActivity {
    //数据源列表
    private String[] mListStr = {"姓名：张三", "性别：男", "年龄：25", "居住地：青岛", "邮箱：itshixun@gmail.com"};
    ListView mListView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_demo2);
        mListView = findViewById(R.id.listview);
        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mListStr));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewDemoActivity.this, "您选择了" + mListStr[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
