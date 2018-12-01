package com.example.andy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.networktest.App;
import com.example.networktest.HttpCallbackListener;
import com.example.networktest.HttpUtil;
import com.example.networktest.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Map> list;
    ListView responseText;
    private static final int msgKey1 = 1;

    private TextView SystemTime;//定义一个获取系统日期的变量

    private String jsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button sendRequest = findViewById(R.id.send_request);
        Button left = findViewById(R.id.left);
        responseText = findViewById(R.id.response_text);
        SystemTime = findViewById(R.id.mytime);


        new TimeThread().start(); //启动新线程

        sendRequest.setOnClickListener(this);
        left.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_request) {
//            sendRequestWithHttpURLConnection();
//              sendRequestWithOkHttp();
//            test();
            test2();
        }else if(v.getId() ==R.id.left){
            Intent intent = new Intent(this,Activity_Left.class);
            startActivity(intent);
        }
    }

    private void test() {
        String string = Util.getJson("get_data.json", this);
        string = string.substring(21, string.length() - 1);
        showResponse(string);
        String jsonData = new String(string);
        parseJSONWithGSON(jsonData);
    }

    private void test2() {
        HttpUtil.sendHttpRequest("http://ketansoft.com/kt_onlinemj/mjappoint/appointList", new
                HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                response = response.substring(21, response.length() - 1);
                jsonData = new String(response);
                parseJSONWithGSON(response);
                showResponse(response);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    private void sendRequestWithHttpURLConnection() {
        // 开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    //URL url = new URL("http://ketansoft.com/framework/smartcaver/allevent");
                    URL url = new URL("http://ketansoft.com/kt_onlinemj/mjappoint/appointList");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    // 下面对获取到的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                        System.out.println(line);
                    }

                    String string = response.toString();
                    string = string.substring(21, string.length() - 1);
                    showResponse(string);
                    //保存jsonData
                    jsonData = new String(string);
                    parseJSONWithGSON(string);
                    //测试保存的json数据,返回包含数据的list
                    List<App> list = getList(jsonData);
                    /*for (App app:list)
                   Log.i("MainActivity",""+app.getAddr()+"/"+app.getAppointMan()+"/"+app
                   .getCreateTime()
                           +"/"+app.getEndTime()+"/"+app.getReason()+"/"+app.getStartTime());*/

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }

            }
        }).start();
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            // 指定访问的服务器地址是电脑本机
                            //.url("http://10.0.2.2/get_data.json")
                            // .url("http://ketansoft.com/framework/smartcaver/allevent")
                            .url("http://ketansoft.com/kt_onlinemj/mjappoint/appointList")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJSONWithGSON(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>() {
        }.getType());
        list = new ArrayList<>();
        for (App app : appList) {
//            Log.d("MainActivity", "addr is " + app.getAddr());
//            Log.d("MainActivity", "appointMan is " + app.getAppointMan());
//            Log.d("MainActivity", "createTime is " + app.getCreateTime());
//            Log.d("MainActivity", "startTime is " + app.getStartTime());
//            Log.d("MainActivity", "endTime is " + app.getEndTime());
//            Log.d("MainActivity", "reason is " + app.getReason());
            Map<String, String> map = new HashMap<>();
            map.put("addr", app.getAddr());
            map.put("appointMan", app.getAppointMan());
            map.put("createTime", app.getCreateTime());
            map.put("startTime", app.getStartTime());
            map.put("endTime", app.getEndTime());
            map.put("reason", app.getReason());
            list.add(map);
        }
    }

    private List getList(String jsonData) {
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>() {
        }.getType());
        return appList;
    }


    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，将结果显示到界面上
//                responseText.setText(response);
                ListAdapter adapter = new ListAdapter(com.example.andy.MainActivity.this, list);
                responseText.setAdapter(adapter);
            }
        });
    }


    public class TimeThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = msgKey1;     //消息(一个整型值)
                    mHandler.sendMessage(msg);      // 每隔1秒发送一个msg给mHandler
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } while (true);
        }

        //在主线程里面处理消息并更新UI界面
        private Handler mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case msgKey1:
                        SystemTime.setText(getTime());
                        break;
                    default:
                        break;
                }
            }
        };

        //获得当前年月日时分秒星期
        public String getTime() {
            final Calendar c = Calendar.getInstance();
            c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
            String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
            String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
            String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
            String mHour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));//时

            return mYear + "年" + mMonth + "月" + mDay + "日";
        }


    }

}