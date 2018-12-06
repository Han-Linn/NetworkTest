package com.qst.chapter04.activity;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class TabDemoActivity extends Activity implements
		ActionBar.TabListener {
	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar = getActionBar();
		// 导航模式必须设为NAVIGATION_MODE_Tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);//

		// 为每一个Tab设置监听器

		actionBar
				.addTab(actionBar.newTab().setText("选项1").setTabListener(this));
		actionBar
				.addTab(actionBar.newTab().setText("选项2").setTabListener(this));
		actionBar
				.addTab(actionBar.newTab().setText("选项3").setTabListener(this));

	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
							  FragmentTransaction fragmentTransaction) {
		//当选择了tab后，通过Toast显示响应文字
		switch (tab.getPosition()) {
			case 0:
				Toast.makeText(this, "选项1", Toast.LENGTH_SHORT).show();
				break;
			case 1:
				Toast.makeText(this, "选项2", Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(this, "选项3", Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
		}

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

}
