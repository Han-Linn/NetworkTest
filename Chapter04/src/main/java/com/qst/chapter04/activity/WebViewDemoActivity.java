package com.qst.chapter04.activity;

import com.qst.chapter04.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebViewDemoActivity extends AppCompatActivity{
	//定义WebView类型的变量
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview_demo);
		//获取webview对象，并加载百度首页
		webView =(WebView)findViewById(R.id.webView);
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append("<html>");
		htmlBuffer.append("<body>请点击<a href=\"http://www.baidu.com\">百度</a></body>");
		htmlBuffer.append("</html>");
		webView.loadDataWithBaseURL("",htmlBuffer.toString(),"text/html","UTF-8","");
	}
}
