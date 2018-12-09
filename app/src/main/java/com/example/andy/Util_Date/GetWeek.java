package com.example.andy.Util_Date;

public class GetWeek {
    public static String getWeek(String mWay) {
        switch (mWay) {
            case "0":
                mWay = "日";
                break;
            case "1":
                mWay = "一";
                break;
            case "2":
                mWay = "二";
                break;
            case "3":
                mWay = "三";
                break;
            case "4":
                mWay = "四";
                break;
            case "5":
                mWay = "五";
                break;
            case "6":
                mWay = "六";
                break;
        }
        return mWay;
    }
}
