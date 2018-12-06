package com.qst.chapter04.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.qst.chapter04.R;


public class TabHostDemo2Activity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabhost_demo2);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("标签1").setContent(R.id.content_1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("标签2").setContent(R.id.content_2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("标签3").setContent(R.id.content_3));

        // 设置选项卡的高度和宽度
        TabWidget mTabWidget = tabHost.getTabWidget();
        for (int i = 0; i < mTabWidget.getChildCount(); i++) {
            // 设置选项卡的高度
            mTabWidget.getChildAt(i).getLayoutParams().height = 80;
            // 设置选项卡的宽度
            mTabWidget.getChildAt(i).getLayoutParams().width = 60;

        }
    }
}
