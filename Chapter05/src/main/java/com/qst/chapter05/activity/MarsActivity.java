package com.qst.chapter05.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.qst.chapter05.R;

public class MarsActivity extends AppCompatActivity{
	private Button button  = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mars_layout);
		Intent EarthIntent = getIntent();
		String EarthMessage = EarthIntent.getStringExtra("FromEarth");
		button = (Button) findViewById(R.id.btn4);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MarsActivity.this,
						OnActivityResultActivity.class);
				String passString = "火星来的消息:我是火星Jack，非常高兴你能来火星";
				intent.putExtra("FromMars", passString);
				setResult(RESULT_OK, intent);
				finish();
			}
		});
		TextView textView = (TextView) findViewById(R.id.txv3);
		textView.setText(EarthMessage);
	}
}
