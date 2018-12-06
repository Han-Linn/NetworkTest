package com.qst.chapter04.activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.qst.chapter04.R;

public class ListActivityDemo extends ListActivity {
	//数据源列表
	private String[] mListStr = { "姓名：张三", "性别：男", "年龄：25", "居住地：青岛", "邮箱：itshixun@gmail.com" };
	ListView mListView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_demo1);
		mListView = getListView();
		mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mListStr));
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(ListActivityDemo.this, "您选择了" + mListStr[position], Toast.LENGTH_LONG).show();
			}
		});

	}
}
