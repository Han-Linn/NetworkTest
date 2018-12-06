package com.qst.chapter04.activity;

import com.qst.chapter04.R;
import com.qst.chapter04.adapter.ImageAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewDemoActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview_demo);
		GridView gridView= findViewById(R.id.gridview);
		ImageAdapter imageAdapter = new ImageAdapter(this,mThumbIds);
		gridView.setAdapter(imageAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(GridViewDemoActivity.this,mThumbIds[position], Toast.LENGTH_SHORT).show();
			}
		});
	}
	private int[] mThumbIds = {
			R.mipmap.flg_1, R.mipmap.flg_2,
			R.mipmap.flg_3, R.mipmap.flg_4,
			R.mipmap.flg_5, R.mipmap.flg_6,
			R.mipmap.flg_7, R.mipmap.flg_8,
			R.mipmap.flg_9
	};

}

