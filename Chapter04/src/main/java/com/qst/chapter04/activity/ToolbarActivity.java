package com.qst.chapter04.activity;

import com.qst.chapter04.R;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class ToolbarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitle("ToolbarDemo");
        setSupportActionBar(toolbar);
        // 显示应用的Logo并设置图标
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        // 显示标题和子标题并设置颜色

        toolbar.setCollapsible(true);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitle("Android基础");
        toolbar.setSubtitleTextColor(Color.WHITE);
        // 显示导航按钮图标
        toolbar.setNavigationIcon(R.mipmap.ic_drawer_home);
        toolbar.inflateMenu(R.menu.menu_toolbar_demo);
    }
    //显示Menu菜单按钮
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_toolbar_demo, menu);
//        return true;
//    }
  }