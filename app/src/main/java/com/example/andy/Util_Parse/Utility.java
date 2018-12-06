package com.example.andy.Util_Parse;

import com.example.andy.JavaBean.GetCourse;
import com.example.andy.JavaBean.App;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    //用GSON解析预约JSON数据
    public List<App> parseJSONWithGSON1(String jsonData) {
        Gson gson = new Gson();
        List<com.example.andy.JavaBean.App> appList = gson.fromJson(jsonData, new
                TypeToken<List<com.example.andy.JavaBean.App>>() {
                }.getType());
//        list = new ArrayList<>();
//        for (App app : appList) {
//            Map<String, String> map = new HashMap<>();
//            map.put("addr", app.getAddr());
//            map.put("appointMan", app.getAppointMan());
//            map.put("createTime", app.getCreateTime());
//            map.put("startTime", app.getStartTime());
//            map.put("endTime", app.getEndTime());
//            map.put("reason", app.getReason());
//            list.add(map);
//        }

        List<App> list = new ArrayList<>();
        com.example.andy.JavaBean.App app = null;
        for (com.example.andy.JavaBean.App data : appList) {
            app = new com.example.andy.JavaBean.App();
            app.setAppointMan(data.getAppointMan());
            app.setCreateTime(data.getCreateTime());
            app.setStartTime(data.getStartTime());
            app.setAddr(data.getAddr());
            app.setEndTime(data.getEndTime());
            app.setReason(data.getReason());
            list.add(app);
        }
        return list;
    }


    //用JSONObject解析课表JSON数据
    public List<GetCourse> parseJSONWithGSON2(String jsonData) {
        List<GetCourse> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            GetCourse getcourse = null;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject != null) {
                    getcourse = new GetCourse();
                    getcourse.setClazz(jsonObject.getString("clazz"));
                    getcourse.setCourseName(jsonObject.getString("courseName"));
                    getcourse.setTeacher(jsonObject.getString("teacher"));
                } else {
                    getcourse = new GetCourse();
                    getcourse.setClazz("");
                    getcourse.setCourseName("");
                    getcourse.setTeacher("");
                }
                list.add(getcourse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}