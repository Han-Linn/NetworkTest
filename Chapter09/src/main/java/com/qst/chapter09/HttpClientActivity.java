package com.qst.chapter09;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by Adminstrator on 2016/10/24.
 */

public class HttpClientActivity extends AppCompatActivity{
    private Button requestButton;
    private HttpResponse httpResponse;
    private HttpEntity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_layout);
        requestButton = (Button) findViewById(R.id.requestButton);

        requestButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Downtest()).start();
            }
        });
    }
    class Downtest implements Runnable{

        public void run() {
            //生成一个请求对象,请求
            HttpGet get = new HttpGet("http://www.baidu.com");
            //生成一个Http客户端对象
            HttpClient hClient = new DefaultHttpClient();
            //使用Http客户端发送请求对象
            InputStream inputStream = null;
            try {
                httpResponse = hClient.execute(get);//httpResponse返回的响应
                //返回的响应数据就放在里边
                entity = httpResponse.getEntity();
                inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String result = "";
                String line = "";
                while((line = reader.readLine())!= null){
                    result = result+ line;
                }
                Log.d("HttpClient",result);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                try{
                    inputStream.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
