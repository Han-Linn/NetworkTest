package com.qst.chapter06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Adminstrator on 2016/11/10.
 */

public class SMSActivity extends AppCompatActivity{
	private TextView mTextView;
	private SMSBroadcastReceiver mSMSBroadcastReceiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_layout);
		init();
	}
	private void init(){
		mTextView=(TextView) findViewById(R.id.txv1);
		mSMSBroadcastReceiver=new SMSBroadcastReceiver();
		mSMSBroadcastReceiver.setOnReceivedMessageListener(new SMSBroadcastReceiver.MessageListener() {
			@Override
			public void OnReceived(String message) {
				mTextView.setText(message);
			}
		});
	}

}
