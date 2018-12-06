package com.qst.chapter03;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

//实现事件监听器接口
public class EventBtnActivity extends Activity implements OnClickListener{
	//点击Button
	private Button clickBtn;
	//文字显示
	private TextView showTxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_btn);
		//初始化组件
		showTxt = findViewById(R.id.showTxt);
		clickBtn = findViewById(R.id.clickBtn);
		// 直接使用Activity作为事件监听器
		clickBtn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// 实现事件处理方法
		showTxt.setText("btn按钮被单击了！");
	}
}
