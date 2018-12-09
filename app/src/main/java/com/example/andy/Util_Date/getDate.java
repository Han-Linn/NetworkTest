package com.example.andy.Util_Date;

import com.example.andy.JavaBean.SendCourse;

import java.util.Calendar;
import java.util.TimeZone;

public class getDate {
    public static String getTime() {
        SendCourse sc = new SendCourse();
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        return mYear + "年" + mMonth + "月" + mDay + "日" + " " + "星期" + GetWeek.getWeek(mWay) + " "
                + "第" + sc.getZc1()
                + "周";
    }

    public static String getTime2() {
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        return mYear + "年" + mMonth + "月" + mDay + "日";
    }
}
