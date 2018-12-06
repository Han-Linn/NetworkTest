package com.qst.chapter04.activity;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;
/**
 * 菜单Demo
 *
 */
public class MenuDemoActivity extends AppCompatActivity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// 调用父类方法来加入系统菜单
//		super.onCreateOptionsMenu(menu);
//		// 添加菜单项
//		menu.add("菜单项1");
//		menu.add("菜单项2");
//		menu.add("菜单项3");
//		// 如果希望显示菜单，请返回true
//		return true;
//	}

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		// 添加4个菜单项，分成2组
		int group1 = 1;
		int gourp2 = 2;
		menu.add(group1, 1, 1, "菜单项1");
		menu.add(group1, 2, 2, "菜单项2");
		menu.add(gourp2, 3, 3, "菜单项3");
		menu.add(gourp2, 4, 4, "菜单项4");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case 1:
				Toast.makeText(this, "菜单项1", Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(this, "菜单项2", Toast.LENGTH_SHORT).show();
				break;
			case 3:
				Toast.makeText(this, "菜单项3", Toast.LENGTH_SHORT).show();
				break;
			case 4:
				Toast.makeText(this, "菜单项4", Toast.LENGTH_SHORT).show();
				break;
		}
		return super.onOptionsItemSelected(item);
	}

//	@Override
//	public final boolean onMenuItemSelected(int featureId, MenuItem item) {
//		switch (item.getItemId()) {
//			case 1:
//				Toast.makeText(this, "菜单项11", Toast.LENGTH_SHORT).show();
//				break;
//			case 2:
//				Toast.makeText(this, "菜单项22", Toast.LENGTH_SHORT).show();
//				break;
//			case 3:
//				Toast.makeText(this, "菜单项33", Toast.LENGTH_SHORT).show();
//				break;
//			case 4:
//				Toast.makeText(this, "菜单项44", Toast.LENGTH_SHORT).show();
//				break;
//		}
//		return super.onMenuItemSelected(featureId, item);
//	}
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		int base = Menu.FIRST;
//		// 一个menu可以包括多个子菜单
//		SubMenu subMenu = menu.addSubMenu(base, base+1, Menu.NONE, "系统设置");
//		// 子菜单可以包括多个菜单项
//		MenuItem menuitem1 = subMenu.add(base, base+1, base+1, "显示设置");
//		subMenu.add(base, base+2, base+2, "网络设置");
//		subMenu.add(base, base+3, base+3, "高级设置");
//		subMenu.add(base, base+4, base+4, "安全设置");
//
//
//		//但是子菜单本身是支持图标的
//		// subMenu.setIcon(R.drawable.settings);
//
//		// 显示菜单请返回true
//		return true;
//	}

}
