package com.qst.chapter04.activity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;

import com.qst.chapter04.R;

public class TabHostDemo1Activity  extends TabActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost_demo1);

		TabHost tabHost = getTabHost();

		TabSpec page1 = tabHost.newTabSpec("tab1").setIndicator("标签1")
				.setContent(R.id.content1);
		tabHost.addTab(page1);

		TabSpec page2 = tabHost.newTabSpec("tab2").setIndicator("标签2")
				.setContent(R.id.content2);
		tabHost.addTab(page2);

		TabSpec page3 = tabHost.newTabSpec("tab3").setIndicator("标签3")
				.setContent(R.id.content3);
		tabHost.addTab(page3);
		// 设置选项卡的高度和宽度
		TabWidget mTabWidget = tabHost.getTabWidget();
		for (int i = 0; i < mTabWidget.getChildCount(); i++) {
			// 设置选项卡的高度
			mTabWidget.getChildAt(i).getLayoutParams().height =80;
			// 设置选项卡的宽度
			mTabWidget.getChildAt(i).getLayoutParams().width = 60;

		}
	}
}
