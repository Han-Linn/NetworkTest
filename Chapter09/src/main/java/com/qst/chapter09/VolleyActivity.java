package com.qst.chapter09;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adminstrator on 2016/10/24.
 */

public class VolleyActivity extends AppCompatActivity {
    private Button get_btn;
    private Button post_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_layout);

        get_btn= (Button) findViewById(R.id.get_btn);
        post_btn= (Button) findViewById(R.id.post_btn);

        get_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GET请求
                VolleyGet();
            }
        });

        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // POST请求
                VolleyPost();
            }
        });
    }

    // 定义POST请求的方法
    private void VolleyPost() {
        // 请求地址
        String url = "http://www.itshixun.com/index";

        // 创建StringRequest，定义字符串请求的请求方式为POST，
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 请求成功后执行的函数
            @Override
            public void onResponse(String response) {
                // 打印出POST请求返回的字符串
                Log.d("VolleyPost","Post"+response);
            }
        }, new Response.ErrorListener() {
            // 请求失败时执行的函数
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }){

            // 定义请求数据
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("phone", "400-658-0166");
                return hashMap;
            }
        };
        // 设置该请求的标签
        request.setTag("postRequest");

        // 将请求添加到队列中
        MyApplication.getHttpQueue().add(request);
    }

    // 定义GET请求的方法
    private void VolleyGet() {
        // 定义请求地址
        String url = "http://www.itshixun.com/index";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                // 打印出GET请求返回的字符串
                Log.d("VolleyGet","Get"+s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        // 设置该请求的标签
        request.setTag("getRequest");

        // 将请求添加到队列中
        MyApplication.getHttpQueue().add(request);
    }
}
