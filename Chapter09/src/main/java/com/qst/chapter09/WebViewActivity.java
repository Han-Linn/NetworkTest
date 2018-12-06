package com.qst.chapter09;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Adminstrator on 2016/10/24.
 */

public class WebViewActivity extends AppCompatActivity {
    private EditText url;
    private WebView show;
    private Button connect;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewbrowser_actvivity);
        //获取页面中文本框、WebView组件
        url= (EditText) findViewById(R.id.url);
        show= (WebView) findViewById(R.id.show);
        connect= (Button) findViewById(R.id.connect);
        WebSettings webSettings = show.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        //设置WebViewClient
        show.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }
            @Override
            public void onPageFinished(WebView view, String url)
            {
                super.onPageFinished(view, url);
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon)
            {
                super.onPageStarted(view, url, favicon);
            }
        });
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlStr=url.getText().toString();
                show.loadUrl("http://"+urlStr);
            }
        });
    }
}
