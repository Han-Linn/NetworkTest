package com.example.andy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.andy.JavaBean.GetCourse;
import com.example.andy.JavaBean.SendCourse;
import com.example.andy.Util_Http.HttpCallbackListener;
import com.example.andy.Util_Http.HttpUtil;
import com.example.andy.Util_Http.HttpUtli2;
import com.example.andy.Util_Http.OnResponseListner;
import com.example.andy.Util_Parse.Utility;
import com.example.networktest.R;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import okhttp3.Call;
import okhttp3.Response;

public class Activity_Course extends AppCompatActivity implements View.OnClickListener {
    private List<GetCourse> list;
    private Button appointment;
    private TextView yi_12_1, yi_12_2, yi_12_3, yi_34_1, yi_34_2, yi_34_3, yi_56_1, yi_56_2,
            yi_56_3, yi_78_1, yi_78_2, yi_78_3, yi_910_1, yi_910_2, yi_910_3, yi_1112_1, yi_1112_2,
            yi_1112_3, er_12_1, er_12_2, er_12_3, er_34_1, er_34_2, er_34_3, er_56_1, er_56_2,
            er_56_3, er_78_1, er_78_2, er_78_3, er_910_1, er_910_2, er_910_3, er_1112_1, er_1112_2,
            er_1112_3, san_12_1, san_12_2, san_12_3, san_34_1, san_34_2, san_34_3, san_56_1,
            san_56_2, san_56_3, san_78_1, san_78_2, san_78_3, san_910_1, san_910_2, san_910_3,
            san_1112_1,
            san_1112_2, san_1112_3, si_12_1, si_12_2, si_12_3, si_34_1, si_34_2, si_34_3,
            si_56_1, si_56_2,
            si_56_3, si_78_1, si_78_2, si_78_3, si_910_1, si_910_2, si_910_3, si_1112_1, si_1112_2,
            si_1112_3, wu_12_1, wu_12_2, wu_12_3, wu_34_1, wu_34_2, wu_34_3, wu_56_1, wu_56_2,
            wu_56_3, wu_78_1, wu_78_2, wu_78_3, wu_910_1, wu_910_2, wu_910_3, wu_1112_1, wu_1112_2,
            wu_1112_3, liu_12_1, liu_12_2, liu_12_3, liu_34_1, liu_34_2, liu_34_3, liu_56_1,
            liu_56_2, liu_56_3, liu_78_1, liu_78_2, liu_78_3, liu_910_1, liu_910_2, liu_910_3,
            liu_1112_1, liu_1112_2,
            liu_1112_3, qi_12_1, qi_12_2, qi_12_3, qi_34_1, qi_34_2, qi_34_3, qi_56_1, qi_56_2,
            qi_56_3, qi_78_1, qi_78_2, qi_78_3, qi_910_1, qi_910_2, qi_910_3, qi_1112_1,
            qi_1112_2, qi_1112_3;
    private static final int msgKey1 = 1;
    private TextView SystemTime;//定义一个获取系统日期的变量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course);
        init();
        setOnclick();
//        new TimeThread().start(); //启动新线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    sendOkHttpRequest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void setOnclick() {
        appointment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.oppointment:
                Intent intent = new Intent(this, Activity_Appointment.class);
                startActivity(intent);
                break;
        }
    }

    //获取课表数据1
    private void sendOkHttpRequest() {
        final SendCourse sc = new SendCourse();
        HttpUtli2.postRequest2(sc.getUrl(), sc.getMap(), sc.getEncode(), new OnResponseListner() {
            @Override
            public void onSucess(String response) {
//                Log.d("Activity_Course第一", "------------------------" + response);
                if (response.length() > 31) {
                    list = Utility.parseJSONWithGSON2(response.substring(11, response.length() - 31));
//                    Log.d("Activity_Course第一", "------------------------" + response.substring(11, response.length() - 31));
                    Log.d("Activity_Course第一", "------------------------" + list.get(2).getCourseName());
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }


    //显示ListView
    private void showResponse() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showText();
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

    private void init() {
        appointment = findViewById(R.id.oppointment);
        SystemTime = findViewById(R.id.mytime);
        yi_12_1 = findViewById(R.id.yi_12_1);
        yi_12_2 = findViewById(R.id.yi_12_2);
        yi_12_3 = findViewById(R.id.yi_12_3);
        yi_34_1 = findViewById(R.id.yi_34_1);
        yi_34_2 = findViewById(R.id.yi_34_2);
        yi_34_3 = findViewById(R.id.yi_34_3);
        yi_56_1 = findViewById(R.id.yi_56_1);
        yi_56_2 = findViewById(R.id.yi_56_2);
        yi_56_3 = findViewById(R.id.yi_56_3);
        yi_78_1 = findViewById(R.id.yi_78_1);
        yi_78_2 = findViewById(R.id.yi_78_2);
        yi_78_3 = findViewById(R.id.yi_78_3);
        yi_910_1 = findViewById(R.id.yi_910_1);
        yi_910_2 = findViewById(R.id.yi_910_2);
        yi_910_3 = findViewById(R.id.yi_910_3);
        yi_1112_1 = findViewById(R.id.yi_1112_1);
        yi_1112_2 = findViewById(R.id.yi_1112_2);
        yi_1112_3 = findViewById(R.id.yi_1112_3);
        er_12_1 = findViewById(R.id.er_12_1);
        er_12_2 = findViewById(R.id.er_12_2);
        er_12_3 = findViewById(R.id.er_12_3);
        er_34_1 = findViewById(R.id.er_34_1);
        er_34_2 = findViewById(R.id.er_34_2);
        er_34_3 = findViewById(R.id.er_34_3);
        er_56_1 = findViewById(R.id.er_56_1);
        er_56_2 = findViewById(R.id.er_56_2);
        er_56_3 = findViewById(R.id.er_56_3);
        er_78_1 = findViewById(R.id.er_78_1);
        er_78_2 = findViewById(R.id.er_78_2);
        er_78_3 = findViewById(R.id.er_78_3);
        er_910_1 = findViewById(R.id.er_910_1);
        er_910_2 = findViewById(R.id.er_910_2);
        er_910_3 = findViewById(R.id.er_910_3);
        er_1112_1 = findViewById(R.id.er_1112_1);
        er_1112_2 = findViewById(R.id.er_1112_2);
        er_1112_3 = findViewById(R.id.er_1112_3);
        san_12_1 = findViewById(R.id.san_12_1);
        san_12_2 = findViewById(R.id.san_12_2);
        san_12_3 = findViewById(R.id.san_12_3);
        san_34_1 = findViewById(R.id.san_34_1);
        san_34_2 = findViewById(R.id.san_34_2);
        san_34_3 = findViewById(R.id.san_34_3);
        san_56_1 = findViewById(R.id.san_56_1);
        san_56_2 = findViewById(R.id.san_56_2);
        san_56_3 = findViewById(R.id.san_56_3);
        san_78_1 = findViewById(R.id.san_78_1);
        san_78_2 = findViewById(R.id.san_78_2);
        san_78_3 = findViewById(R.id.san_78_3);
        san_910_1 = findViewById(R.id.san_910_1);
        san_910_2 = findViewById(R.id.san_910_2);
        san_910_3 = findViewById(R.id.san_910_3);
        san_1112_1 = findViewById(R.id.san_1112_1);
        san_1112_2 = findViewById(R.id.san_1112_2);
        san_1112_3 = findViewById(R.id.san_1112_3);
        si_12_1 = findViewById(R.id.si_12_1);
        si_12_2 = findViewById(R.id.si_12_2);
        si_12_3 = findViewById(R.id.si_12_3);
        si_34_1 = findViewById(R.id.si_34_1);
        si_34_2 = findViewById(R.id.si_34_2);
        si_34_3 = findViewById(R.id.si_34_3);
        si_56_1 = findViewById(R.id.si_56_1);
        si_56_2 = findViewById(R.id.si_56_2);
        si_56_3 = findViewById(R.id.si_56_3);
        si_78_1 = findViewById(R.id.si_78_1);
        si_78_2 = findViewById(R.id.si_78_2);
        si_78_3 = findViewById(R.id.si_78_3);
        si_910_1 = findViewById(R.id.si_910_1);
        si_910_2 = findViewById(R.id.si_910_2);
        si_910_3 = findViewById(R.id.si_910_3);
        si_1112_1 = findViewById(R.id.si_1112_1);
        si_1112_2 = findViewById(R.id.si_1112_2);
        si_1112_3 = findViewById(R.id.si_1112_3);
        wu_12_1 = findViewById(R.id.wu_12_1);
        wu_12_2 = findViewById(R.id.wu_12_2);
        wu_12_3 = findViewById(R.id.wu_12_3);
        wu_34_1 = findViewById(R.id.wu_34_1);
        wu_34_2 = findViewById(R.id.wu_34_2);
        wu_34_3 = findViewById(R.id.wu_34_3);
        wu_56_1 = findViewById(R.id.wu_56_1);
        wu_56_2 = findViewById(R.id.wu_56_2);
        wu_56_3 = findViewById(R.id.wu_56_3);
        wu_78_1 = findViewById(R.id.wu_78_1);
        wu_78_2 = findViewById(R.id.wu_78_2);
        wu_78_3 = findViewById(R.id.wu_78_3);
        wu_910_1 = findViewById(R.id.wu_910_1);
        wu_910_2 = findViewById(R.id.wu_910_2);
        wu_910_3 = findViewById(R.id.wu_910_3);
        wu_1112_1 = findViewById(R.id.wu_1112_1);
        wu_1112_2 = findViewById(R.id.wu_1112_2);
        wu_1112_3 = findViewById(R.id.wu_1112_3);
        liu_12_1 = findViewById(R.id.liu_12_1);
        liu_12_2 = findViewById(R.id.liu_12_2);
        liu_12_3 = findViewById(R.id.liu_12_3);
        liu_34_1 = findViewById(R.id.liu_34_1);
        liu_34_2 = findViewById(R.id.liu_34_2);
        liu_34_3 = findViewById(R.id.liu_34_3);
        liu_56_1 = findViewById(R.id.liu_56_1);
        liu_56_2 = findViewById(R.id.liu_56_2);
        liu_56_3 = findViewById(R.id.liu_56_3);
        liu_78_1 = findViewById(R.id.liu_78_1);
        liu_78_2 = findViewById(R.id.liu_78_2);
        liu_78_3 = findViewById(R.id.liu_78_3);
        liu_910_1 = findViewById(R.id.liu_910_1);
        liu_910_2 = findViewById(R.id.liu_910_2);
        liu_910_3 = findViewById(R.id.liu_910_3);
        liu_1112_1 = findViewById(R.id.liu_1112_1);
        liu_1112_2 = findViewById(R.id.liu_1112_2);
        liu_1112_3 = findViewById(R.id.liu_1112_3);
        qi_12_1 = findViewById(R.id.qi_12_1);
        qi_12_2 = findViewById(R.id.qi_12_2);
        qi_12_3 = findViewById(R.id.qi_12_3);
        qi_34_1 = findViewById(R.id.qi_34_1);
        qi_34_2 = findViewById(R.id.qi_34_2);
        qi_34_3 = findViewById(R.id.qi_34_3);
        qi_56_1 = findViewById(R.id.qi_56_1);
        qi_56_2 = findViewById(R.id.qi_56_2);
        qi_56_3 = findViewById(R.id.qi_56_3);
        qi_78_1 = findViewById(R.id.qi_78_1);
        qi_78_2 = findViewById(R.id.qi_78_2);
        qi_78_3 = findViewById(R.id.qi_78_3);
        qi_910_1 = findViewById(R.id.qi_910_1);
        qi_910_2 = findViewById(R.id.qi_910_2);
        qi_910_3 = findViewById(R.id.qi_910_3);
        qi_1112_1 = findViewById(R.id.qi_1112_1);
        qi_1112_2 = findViewById(R.id.qi_1112_2);
        qi_1112_3 = findViewById(R.id.qi_1112_3);
    }

    private void showText() {
        if (list.size() != 0) {
            yi_12_1.setText(list.get(0).getClazz());
            yi_12_2.setText(list.get(0).getCourseName());
            yi_12_3.setText(list.get(0).getTeacher());
            yi_34_1.setText(list.get(1).getClazz());
            yi_34_2.setText(list.get(1).getCourseName());
            yi_34_3.setText(list.get(1).getTeacher());
            yi_56_1.setText(list.get(2).getClazz());
            yi_56_2.setText(list.get(2).getCourseName());
            yi_56_3.setText(list.get(2).getTeacher());
            yi_78_1.setText(list.get(3).getClazz());
            yi_78_2.setText(list.get(3).getCourseName());
            yi_78_3.setText(list.get(3).getTeacher());
            yi_910_1.setText(list.get(4).getClazz());
            yi_910_2.setText(list.get(4).getCourseName());
            yi_910_3.setText(list.get(4).getTeacher());
            yi_1112_1.setText(list.get(5).getClazz());
            yi_1112_2.setText(list.get(5).getCourseName());
            yi_1112_3.setText(list.get(5).getTeacher());
            er_12_1.setText(list.get(6).getClazz());
            er_12_2.setText(list.get(6).getCourseName());
            er_12_3.setText(list.get(6).getTeacher());
            er_34_1.setText(list.get(7).getClazz());
            er_34_2.setText(list.get(7).getCourseName());
            er_34_3.setText(list.get(7).getTeacher());
            er_56_1.setText(list.get(8).getClazz());
            er_56_2.setText(list.get(8).getCourseName());
            er_56_3.setText(list.get(8).getTeacher());
            er_78_1.setText(list.get(9).getClazz());
            er_78_2.setText(list.get(9).getCourseName());
            er_78_3.setText(list.get(9).getTeacher());
            er_910_1.setText(list.get(10).getClazz());
            er_910_2.setText(list.get(10).getCourseName());
            er_910_3.setText(list.get(10).getTeacher());
            er_1112_1.setText(list.get(11).getClazz());
            er_1112_2.setText(list.get(11).getCourseName());
            er_1112_3.setText(list.get(11).getTeacher());
            san_12_1.setText(list.get(12).getClazz());
            san_12_2.setText(list.get(12).getCourseName());
            san_12_3.setText(list.get(12).getTeacher());
            san_34_1.setText(list.get(13).getClazz());
            san_34_2.setText(list.get(13).getCourseName());
            san_34_3.setText(list.get(13).getTeacher());
            san_56_1.setText(list.get(14).getClazz());
            san_56_2.setText(list.get(14).getCourseName());
            san_56_3.setText(list.get(14).getTeacher());
            san_78_1.setText(list.get(15).getClazz());
            san_78_2.setText(list.get(15).getCourseName());
            san_78_3.setText(list.get(15).getTeacher());
            san_910_1.setText(list.get(16).getClazz());
            san_910_2.setText(list.get(16).getCourseName());
            san_910_3.setText(list.get(16).getTeacher());
            san_1112_1.setText(list.get(17).getClazz());
            san_1112_2.setText(list.get(17).getCourseName());
            san_1112_3.setText(list.get(17).getTeacher());
            si_12_1.setText(list.get(18).getClazz());
            si_12_2.setText(list.get(18).getCourseName());
            si_12_3.setText(list.get(18).getTeacher());
            si_34_1.setText(list.get(19).getClazz());
            si_34_2.setText(list.get(19).getCourseName());
            si_34_3.setText(list.get(19).getTeacher());
            si_56_1.setText(list.get(20).getClazz());
            si_56_2.setText(list.get(20).getCourseName());
            si_56_3.setText(list.get(20).getTeacher());
            si_78_1.setText(list.get(21).getClazz());
            si_78_2.setText(list.get(21).getCourseName());
            si_78_3.setText(list.get(21).getTeacher());
            si_910_1.setText(list.get(22).getClazz());
            si_910_2.setText(list.get(22).getCourseName());
            si_910_3.setText(list.get(22).getTeacher());
            si_1112_1.setText(list.get(23).getClazz());
            si_1112_2.setText(list.get(23).getCourseName());
            si_1112_3.setText(list.get(23).getTeacher());
            wu_12_1.setText(list.get(24).getClazz());
            wu_12_2.setText(list.get(24).getCourseName());
            wu_12_3.setText(list.get(24).getTeacher());
            wu_34_1.setText(list.get(25).getClazz());
            wu_34_2.setText(list.get(25).getCourseName());
            wu_34_3.setText(list.get(25).getTeacher());
            wu_56_1.setText(list.get(26).getClazz());
            wu_56_2.setText(list.get(26).getCourseName());
            wu_56_3.setText(list.get(26).getTeacher());
            wu_78_1.setText(list.get(27).getClazz());
            wu_78_2.setText(list.get(27).getCourseName());
            wu_78_3.setText(list.get(27).getTeacher());
            wu_910_1.setText(list.get(28).getClazz());
            wu_910_2.setText(list.get(28).getCourseName());
            wu_910_3.setText(list.get(28).getTeacher());
            wu_1112_1.setText(list.get(29).getClazz());
            wu_1112_2.setText(list.get(29).getCourseName());
            wu_1112_3.setText(list.get(29).getTeacher());
            liu_12_1.setText(list.get(30).getClazz());
            liu_12_2.setText(list.get(30).getCourseName());
            liu_12_3.setText(list.get(30).getTeacher());
            liu_34_1.setText(list.get(31).getClazz());
            liu_34_2.setText(list.get(31).getCourseName());
            liu_34_3.setText(list.get(31).getTeacher());
            liu_56_1.setText(list.get(32).getClazz());
            liu_56_2.setText(list.get(32).getCourseName());
            liu_56_3.setText(list.get(32).getTeacher());
            liu_78_1.setText(list.get(33).getClazz());
            liu_78_2.setText(list.get(33).getCourseName());
            liu_78_3.setText(list.get(33).getTeacher());
            liu_910_1.setText(list.get(34).getClazz());
            liu_910_2.setText(list.get(34).getCourseName());
            liu_910_3.setText(list.get(34).getTeacher());
            liu_1112_1.setText(list.get(35).getClazz());
            liu_1112_2.setText(list.get(35).getCourseName());
            liu_1112_3.setText(list.get(35).getTeacher());
            qi_12_1.setText(list.get(36).getClazz());
            qi_12_2.setText(list.get(36).getCourseName());
            qi_12_3.setText(list.get(36).getTeacher());
            qi_34_1.setText(list.get(37).getClazz());
            qi_34_2.setText(list.get(37).getCourseName());
            qi_34_3.setText(list.get(37).getTeacher());
            qi_56_1.setText(list.get(38).getClazz());
            qi_56_2.setText(list.get(38).getCourseName());
            qi_56_3.setText(list.get(38).getTeacher());
            qi_78_1.setText(list.get(39).getClazz());
            qi_78_2.setText(list.get(39).getCourseName());
            qi_78_3.setText(list.get(39).getTeacher());
            qi_910_1.setText(list.get(40).getClazz());
            qi_910_2.setText(list.get(40).getCourseName());
            qi_910_3.setText(list.get(40).getTeacher());
            qi_1112_1.setText(list.get(41).getClazz());
            qi_1112_2.setText(list.get(41).getCourseName());
            qi_1112_3.setText(list.get(41).getTeacher());
        }
    }
}