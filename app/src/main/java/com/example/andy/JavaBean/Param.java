package com.example.andy.JavaBean;

/**
 * @Author: yaunlh
 * @Date: 2018/11/29
 */
public class Param {
    private String username;
    private String password;

    private String xnxqh;
    private String skyx;
    private String xqid;
    private String jzwid;
    private String zc1;
    private String zc2;
    private String jc1;
    private String jc2;
    private String classroom;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
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

    public String getJzwid() {
        return jzwid;
    }

    public void setJzwid(String jzwid) {
        this.jzwid = jzwid;
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

    public String getJc1() {
        return jc1;
    }

    public void setJc1(String jc1) {
        this.jc1 = jc1;
    }

    public String getJc2() {
        return jc2;
    }

    public void setJc2(String jc2) {
        this.jc2 = jc2;
    }

    @Override
    public String toString() {
        return "Param{" +
                "xnxqh='" + xnxqh + '\'' +
                ", skyx='" + skyx + '\'' +
                ", xqid='" + xqid + '\'' +
                ", jzwid='" + jzwid + '\'' +
                ", zc1='" + zc1 + '\'' +
                ", zc2='" + zc2 + '\'' +
                ", jc1='" + jc1 + '\'' +
                ", jc2='" + jc2 + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
