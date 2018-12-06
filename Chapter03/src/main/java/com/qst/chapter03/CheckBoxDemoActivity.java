package com.qst.chapter03;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class CheckBoxDemoActivity extends AppCompatActivity {
	// 声明复选按钮 ①
	private CheckBox footballChx;
	private CheckBox basketballChx;
	private CheckBox volleyballChx;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkbox_demo);
		// 通过findViewById获得CheckBox对象 ②
		footballChx = findViewById(R.id.footballChx);
		basketballChx =  findViewById(R.id.basketballChx);
		volleyballChx =  findViewById(R.id.volleyballChx);
		//注册事件监听器 ③
		footballChx.setOnCheckedChangeListener(listener);
		basketballChx.setOnCheckedChangeListener(listener);
		volleyballChx.setOnCheckedChangeListener(listener);

	}

	// 响应事件④
	private OnCheckedChangeListener listener = new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {

			switch (buttonView.getId()) {
				//选择足球
			case R.id.footballChx:

				if (isChecked) {
					//Toast的使用⑤
					Toast.makeText(CheckBoxDemoActivity.this, "你喜欢足球",
							Toast.LENGTH_LONG).show();
				}
				break;
			case R.id.basketballChx:
				//选择篮球
				if (isChecked) {
					Toast.makeText(CheckBoxDemoActivity.this, "你喜欢篮球",
							Toast.LENGTH_LONG).show();
				}
			case R.id.volleyballChx:
				//选择排球
				if (isChecked) {
					Toast.makeText(CheckBoxDemoActivity.this, "你喜欢排球",
							Toast.LENGTH_LONG).show();
				}
			default:
				break;
			}

		}
	};
}