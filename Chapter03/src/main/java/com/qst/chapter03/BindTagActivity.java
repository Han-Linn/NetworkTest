package com.qst.chapter03;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//实现事件监听器接口
public class BindTagActivity extends Activity{
	//点击Button
	private Button clickBtn;
	//文字显示
	private TextView showTxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_tag);
		//初始化组件
		showTxt = findViewById(R.id.showTxt);
		clickBtn = findViewById(R.id.clickBtn);
	}

	public void clickMe(View v){
		// 实现事件处理方法
		showTxt.setText("btn按钮被单击了！");
	}
}

