package com.qst.chapter05.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.qst.chapter05.R;

/**
 * Created by Adminstrator on 2016/11/14.
 */

public class Activity_2 extends AppCompatActivity {
	private TextView tx;
	private Button bt;
	@Override
	protected void onCreate( Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_2);
		tx= (TextView) findViewById(R.id.tx_aihao);
		Intent intent=getIntent();
		//先获取用户的喜好个数
		int num=intent.getIntExtra("num",0);
		String str="";
		//遍历喜好的内容
		for (int i=0;i<num;i++){
			str+=intent.getStringExtra(""+i)+" ";
		}
		//显示喜好
		tx.setText(	str);
	}
}
