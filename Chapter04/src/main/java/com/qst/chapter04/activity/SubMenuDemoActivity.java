package com.qst.chapter04.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import java.lang.reflect.Method;

public class SubMenuDemoActivity extends AppCompatActivity  {

	protected void xonCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	// 初始化菜单
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// 添加子菜单
		SubMenu subMenu = menu.addSubMenu(0, 2, Menu.NONE, "基础操作");
		subMenu.setIcon(android.R.drawable.ic_menu_manage);
		setIconEnable(menu);
		// 添加子菜单项
		//重命名菜单项
		MenuItem renameItem = subMenu.add(2, 201, 1, "重命名");
		renameItem.setIcon(android.R.drawable.ic_menu_edit);
		//分享菜单项
		MenuItem shareItem = subMenu.add(2, 202, 2, "分享");
		shareItem.setIcon(android.R.drawable.ic_menu_share);
		//删除菜单项
		MenuItem delItem = subMenu.add(2, 203, 3, "删除");
		delItem.setIcon(android.R.drawable.ic_menu_delete);
		return true;
	}
	//根据菜单执行相应内容
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

			case 201:
				Toast.makeText(getApplicationContext(), "重命名...",
						Toast.LENGTH_SHORT).show();
				break;
			case 202:
				Toast.makeText(getApplicationContext(), "分享...", Toast.LENGTH_SHORT)
						.show();
				break;
			case 203:
				Toast.makeText(getApplicationContext(), "删除...", Toast.LENGTH_SHORT)
						.show();
				break;
		}
		return true;
	}
	private void setIconEnable(Menu menu) {
		try {
			Class<?> clazz = Class.forName("com.android.internal.view.menu.MenuBuilder");
			Method m = clazz.getDeclaredMethod("setOptionalIconsVisible", boolean.class);
			m.setAccessible(true);
			// 下面传入参数
			m.invoke(menu);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
