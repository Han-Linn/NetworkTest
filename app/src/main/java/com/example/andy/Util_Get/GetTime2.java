package com.example.andy.Util_Get;

import android.annotation.TargetApi;
import android.os.Build;

import com.example.andy.Util_Date.traString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class GetTime2 {
    private Date startDate;
    //获取 X月X日的Date对象，两个恶Date比较，不相等的时候在日期
    // 显示XXXX.XX.XX - XXXX.XX.XX，相等则显示XXXX.XX.XX
    private Date endtDate;

    //获取日历对象
    @TargetApi(Build.VERSION_CODES.N)
    public static java.util.Calendar getCalendar(String time) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date start = simpleDateFormat.parse(time);
            c.setTime(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static String getTime(String time) {
        java.util.Calendar c = getCalendar(time);
        String mYear = String.valueOf(c.get(Calendar.YEAR));
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        String mHour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        String mMin = String.valueOf(c.get(Calendar.MINUTE));
        String mSec = String.valueOf(c.get(Calendar.SECOND));
        time = mYear + "年" + mMonth + "月" + mDay + "日" + " " + traString.traStr(mHour) + ":" + traString.traStr(mMin) + ":" + traString.traStr(mSec);
        return time;
    }

    //得到XX月XX日的Date对象
    public Date getStartDate(String startTime) {
        String str = startTime.substring(0, 9);
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startDate = simpleFormatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate;
    }

    public Date getEndtDate(String endTime) {
        String str = endTime.substring(0, 9);
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            endtDate = simpleFormatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return endtDate;
    }


}
