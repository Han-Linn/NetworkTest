package com.example.andy.Util_Date;

public class traString {
    public static String traWeek(String mWay) {
        switch (mWay) {
            case "1":
                mWay = "日";
                break;
            case "2":
                mWay = "一";
                break;
            case "3":
                mWay = "二";
                break;
            case "4":
                mWay = "三";
                break;
            case "5":
                mWay = "四";
                break;
            case "6":
                mWay = "五";
                break;
            case "7":
                mWay = "六";
                break;
        }
        return mWay;
    }

    public static String traStr(String str) {
        switch (str) {
            case "0":
                str = "00";
                break;
            case "1":
                str = "01";
                break;
            case "2":
                str = "02";
                break;
            case "3":
                str = "03";
                break;
            case "4":
                str = "04";
                break;
            case "5":
                str = "05";
                break;
            case "6":
                str = "06";
                break;
            case "7":
                str = "07";
                break;
            case "8":
                str = "08";
                break;
            case "9":
                str = "09";
                break;
        }
        return str;
    }
}
