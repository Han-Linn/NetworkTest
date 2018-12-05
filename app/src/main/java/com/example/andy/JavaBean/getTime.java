package com.example.andy.JavaBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getTime {
    private Date startDate;
    //获取 X月X日的Date对象，两个恶Date比较，不相等的时候在日期
    // 显示XXXX.XX.XX - XXXX.XX.XX，相等则显示XXXX.XX.XX
    private Date endtDate;
    private String startDay;//XX.XX  意为几月几日
    private String endDay;
    private String startHour;//XX:XX  意为几点几分
    private String endHour;
    private Date start;
    private Date end;


    //get方法  获取Date类型便于与当前时间比较
    public Date getStart(String startTime) {
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            start = simpleFormatter.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return start;
    }


    public Date getEnd(String endTime) {
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            end = simpleFormatter.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return end;
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

    //获取XX.XX.XX
    public String getStartDay(String startTime) {
        String yyyy = startTime.substring(0,3);
        String MM = startTime.substring(5,6);
        String dd = startTime.substring(8,9);
        startDay = yyyy+"."+MM+"."+dd;
        return startDay;
    }


    public String getEndDay(String endTime) {
        String yyyy = endTime.substring(0,3);
        String MM = endTime.substring(5,6);
        String dd = endTime.substring(8,9);
        endDay = yyyy+"."+MM+"."+dd;
        return endDay;
    }


    public String getStartHour(String startTime) {
        String HH = startTime.substring(10,11);
        String mm = startTime.substring(13,14);
        startHour = HH+":"+mm;
        return startHour;
    }


    public String getEndHour(String endTime) {
        String HH = endTime.substring(10,11);
        String mm = endTime.substring(13,14);
        endHour = HH+":"+mm;
        return endHour;
    }

    //set方法
    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndtDate(Date endtDate) {
        this.endtDate = endtDate;
    }

    public void setStartDay(String startTime) {
        this.startDay = startTime;
    }

    public void setStarTime(String endTime) {
        this.endDay = endTime;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

}
