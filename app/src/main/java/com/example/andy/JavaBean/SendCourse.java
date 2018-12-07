package com.example.andy.JavaBean;

import java.util.HashMap;
import java.util.Map;

public class SendCourse {
    private String USENAME = "931663592";
    private String PASSWORD = "zcoolshuai18O5";
    private String xnxqh = "2018-2019-1";
    private String skyx = "11";
    private String xqid = "1";
    private String classroom = "实验楼802";
    private String zc1 = "13";
    private String zc2 = "13";
//    private String url = "http://ketansoft.com/kt_onlinemj/tbkc";
    private String url = "http://2u271r1835.51mypc.cn:13683/kt_onlinemj/tbkc";
    private String encode = "utf-8";
    public String getEncode() {
        return encode;
    }

    public Map getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("username", USENAME);
        map.put("password", PASSWORD);
        map.put("xnxqh", xnxqh);
        map.put("skyx", skyx);
        map.put("xqid", xqid);
        map.put("classroom", classroom);
        map.put("zc1", zc1);
        map.put("zc2", zc2);
        return map;
    }

    public String getUrl() {
        return url;
    }

    public String getUSENAME() {
        return USENAME;
    }

    public void setUSENAME(String USENAME) {
        this.USENAME = USENAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getXnxqh() {
        return xnxqh;
    }

    public void setXnxqh(String xnxqh) {
        this.xnxqh = xnxqh;
    }

    public String getSkyx() {
        return skyx;
    }

    public void setSkyx(String skyx) {
        this.skyx = skyx;
    }

    public String getXqid() {
        return xqid;
    }

    public void setXqid(String xqid) {
        this.xqid = xqid;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getZc1() {
        return zc1;
    }

    public void setZc1(String zc1) {
        this.zc1 = zc1;
    }

    public String getZc2() {
        return zc2;
    }

    public void setZc2(String zc2) {
        this.zc2 = zc2;
    }
}
