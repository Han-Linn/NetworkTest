package com.example.andy.Util_Get;

import org.litepal.crud.DataSupport;

public class GetCourse extends DataSupport {
    private String clazz;
    private String courseName;
    private String teacher;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}