package com.example.andy;

public class App {

    private String addr;

    private String appointMan;

    private String createTime;

    private String endTime;

    private String reason;

    private String startTime;

    public App(com.example.networktest.App app) {
        this.addr=app.getAddr();
        this.appointMan=app.getAppointMan();
        this.createTime=app.getCreateTime();
        this.endTime=app.getEndTime();
        this.reason=app.getReason();
        this.startTime=app.getStartTime();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAppointMan() {
        return appointMan;
    }

    public void setAppointMan(String appointMan) {
        this.appointMan = appointMan;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }





}