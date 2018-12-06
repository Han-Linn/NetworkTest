package com.qst.chapter05.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qst.chapter05.R;

public class MoonActivity extends AppCompatActivity{
	private Button button  = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moon_layout);
		Intent EarthIntent = getIntent();
		String EarthMessage = EarthIntent.getStringExtra("FromEarth");
		button = (Button) findViewById(R.id.btn3);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MoonActivity.this,
						OnActivityResultActivity.class);
				String passString = "月球来的消息:我是月球的Lucy,非常欢迎你来月球";
				intent.putExtra("FromMoon", passString);
				setResult(RESULT_OK, intent);
				finish();
			}
		});
		TextView textView = (TextView) findViewById(R.id.txv2);
		textView.setText(EarthMessage);
	}
}
