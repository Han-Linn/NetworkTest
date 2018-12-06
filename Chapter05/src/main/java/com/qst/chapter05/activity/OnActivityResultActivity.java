package com.qst.chapter05.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qst.chapter05.R;

public class OnActivityResultActivity extends AppCompatActivity {
	private Button button = null;
	private Button button1 = null;
	private TextView text = null;
	private static final int Mars = 0;
	private static final int Moon = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onactivityresult_layout);
		text = (TextView) findViewById(R.id.txv1);
		button = (Button) findViewById(R.id.btn1);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(OnActivityResultActivity.this,
						MarsActivity.class);
				String content = "地球来的消息:我是来自地球上的Tom，火星的朋友你好。";
				intent.putExtra("FromEarth", content);
				startActivityForResult(intent, Mars);
			}
		});
		button1 = (Button) findViewById(R.id.btn2);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(OnActivityResultActivity.this,
						MoonActivity.class);
				String content = "地球来的消息:我是来自地球上的Tom，月球的朋友你好。";
				intent.putExtra("FromEarth", content);
				startActivityForResult(intent, Moon);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
									Intent data){
		switch (requestCode) {
			case Mars:
				Bundle MarsBuddle = data.getExtras();
				String MarsMessage = MarsBuddle.getString("FromMars");
				text.setText(MarsMessage);
				break;
			case Moon:
				Bundle MoonBuddle = data.getExtras();
				String MoonMessage = MoonBuddle.getString("FromMoon");
				text.setText(MoonMessage);
				break;
		}
	}
}
