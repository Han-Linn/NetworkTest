package com.qst.chapter05.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.qst.chapter05.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminstrator on 2016/11/14.
 */

public class Activity_1 extends AppCompatActivity {
	private CheckBox checkBox,checkBox2,checkBox3,checkBox4;
	private List<CheckBox> checkBoxs = new ArrayList<CheckBox>();
	private Button button;
	private String content = "";
	@Override
	protected void onCreate( Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_1);

		checkBox= (CheckBox) findViewById(R.id.checkBox);
		checkBox2= (CheckBox) findViewById(R.id.checkBox2);
		checkBox3= (CheckBox) findViewById(R.id.checkBox3);
		checkBox4= (CheckBox) findViewById(R.id.checkBox4);
		button= (Button) findViewById(R.id.button);

		// 添加到集合中
		checkBoxs.add(checkBox);
		checkBoxs.add(checkBox2);
		checkBoxs.add(checkBox3);
		checkBoxs.add(checkBox4);

		button.setOnClickListener(new View.OnClickListener() {


			public void onClick(View v) {
				Bundle bundle=new Bundle();
				int i=0;
				//将选中的喜好放到bundle中
				for (CheckBox cbx : checkBoxs) {
					if (cbx.isChecked()) {
						bundle.putString("" + i, cbx.getText().toString());
						i++;
					}
				}
				//喜好的个数也放到bundle中
				bundle.putInt("num",i);
				Intent intent=new Intent(Activity_1.this,Activity_2.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});

	}
	public void getValues(View v) {


		if ("".equals(content)) {
			content = "请您选择您的爱好";
		}
	}
}
