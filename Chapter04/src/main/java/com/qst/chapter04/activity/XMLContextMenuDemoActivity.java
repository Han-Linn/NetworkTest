package com.qst.chapter04.activity;

import com.qst.chapter04.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 上下文菜单演示Demo
 *
 */
public class XMLContextMenuDemoActivity extends Activity {
	Button contextMenuBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contextmenu);
		// 显示列表
		contextMenuBtn = (Button) findViewById(R.id.contextMenuBtn);
		// 为按钮注册上下文菜单，长按按钮则弹出上下文菜单
		this.registerForContextMenu(contextMenuBtn);

	}

	// 2）生成上下文菜单
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
									ContextMenuInfo menuInfo) {
		Log.d("ContextMenuDemoActivity", "被创建...");
		menu.setHeaderTitle("文件操作");
		getMenuInflater().inflate(R.menu.context_menu, menu);
	}

	// 3）响应上下文菜单项。
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.item_send:
				Toast.makeText(this, "发送...", Toast.LENGTH_SHORT).show();
				break;
			case R.id.item_rename:
				Toast.makeText(this, "重命名...", Toast.LENGTH_SHORT).show();
				break;
			case R.id.item_del:
				Toast.makeText(this, "删除...", Toast.LENGTH_SHORT).show();
				break;
			default:
				return super.onContextItemSelected(item);
		}
		return true;
	}

}
