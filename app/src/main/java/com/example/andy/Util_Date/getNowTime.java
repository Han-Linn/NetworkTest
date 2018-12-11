package com.example.andy.Util_Date;

import com.example.andy.JavaBean.SendCourse;

import java.util.Calendar;
import java.util.TimeZone;

public class getNowTime {
    public static String getMsg() {
        SendCourse sc = new SendCourse();
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        String mhour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        String mMinute = String.valueOf(c.get(Calendar.MINUTE));
        String mSecond = String.valueOf(c.get(Calendar.SECOND));
        return mYear + "年" + mMonth + "月" + mDay + "日" + "  " +
                "第" + sc.getZc1() + "周" + "  " +
                "星期" + traString.traWeek(mWay) + "  " +
                traString.traStr(mhour) + ":" + traString.traStr(mMinute) +"  "+
//                ":" + traString.traStr(mSecond) + "  " +
                sc.getClassroom()+"  "+
                "温度：25℃  相对湿度：75%  二氧化碳浓度：350  甲醛浓度：0.08mg/m3";
    }

    public static String getTime1() {
        SendCourse sc = new SendCourse();
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        String mhour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        String mMinute = String.valueOf(c.get(Calendar.MINUTE));
        String mSecond = String.valueOf(c.get(Calendar.SECOND));
        return mYear + "年" + mMonth + "月" + mDay + "日" + " " + "星期" + traString.traWeek(mWay) + " "
                + " " + traString.traStr(mhour) + ":" + traString.traStr(mMinute) + ":" + traString.traStr(mSecond);
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
