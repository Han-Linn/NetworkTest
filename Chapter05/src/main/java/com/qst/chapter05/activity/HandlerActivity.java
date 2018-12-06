package com.qst.chapter05.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.qst.chapter05.R;

import java.io.InputStream;
import java.net.URL;

public class HandlerActivity extends AppCompatActivity {
	//用于显示ImageView
	ImageView show;
	// 代表从网络下载得到的图片
	Bitmap bitmap;
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0x123) // 如果该消息是本程序发的
			{
				if(bitmap == null){
					show.setImageResource(R.drawable.pagefailed_bg);
				}else{
					// 使用ImageView显示该图片
					show.setImageBitmap(bitmap);
				}
			}
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		show = (ImageView) findViewById(R.id.show);
		new Thread() {
			public void run() {
				try {
					// 定义一个URL对象
					URL url = new URL("http://www.itshixun.com/logo.png");
					// 打开该URL对应的资源的输入流
					InputStream is = url.openStream();
					// 从InputStream中解析出图片
					bitmap = BitmapFactory.decodeStream(is);
					// 发送消息、通知UI组件显示该图片
					handler.sendEmptyMessage(0x123);
					is.close();
				} catch (Exception e) {
					String msg = e.getMessage();
					Log.d("HandlerActivity", msg);
					//出错也返回
					handler.sendEmptyMessage(0x123);
				}
			}
		}.start();
	}
}
