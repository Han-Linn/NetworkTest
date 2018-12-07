package com.example.andy.Util_Parse;

import android.util.Log;

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
    public static List<App> parseJSONWithGSON1(String jsonData) {
        App app = null;
        Gson gson = new Gson();
        List<App> list = new ArrayList<>();
        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>() {}.getType());
        for (App data : appList) {
            app = new App();
            app.setAppointMan(data.getAppointMan());
            app.setCreateTime(data.getCreateTime());
            app.setStartTime(data.getStartTime());
            app.setAddr(data.getAddr());
            app.setEndTime(data.getEndTime());
            app.setReason(data.getReason());
            list.add(app);
          Log.d("Utility","-----------------"+app.getAppointMan());
        }
        return list;

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
    }


    //用JSONObject解析课表JSON数据
    public static List<GetCourse> parseJSONWithGSON2(String jsonData) {
        List<GetCourse> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            Log.d("Utility", "------------------------" + jsonArray.length());
            GetCourse getcourse = null;
            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                jsonObject.length()
//                if (jsonArray.getJSONObject(i).length()>0) {
//                    getcourse = new GetCourse();
//                    getcourse.setClazz(jsonObject.getString("clazz"));
//                    getcourse.setCourseName(jsonObject.getString("courseName"));
//                    getcourse.setTeacher(jsonObject.getString("teacher"));
//                } else {
//                    getcourse = new GetCourse();
//                    getcourse.setClazz("");
//                    getcourse.setCourseName("");
//                    getcourse.setTeacher("");
//                }
//                getcourse = new GetCourse();
//                getcourse.setClazz(jsonObject.getString("clazz"));
//                getcourse.setCourseName(jsonObject.getString("courseName"));
//                getcourse.setTeacher(jsonObject.getString("teacher"));
//                list.add(getcourse);
            }
            Log.d("Utility", "------------------------" + jsonArray.getJSONObject(2).length());
            Log.d("Utility", "------------------------" + jsonArray.getJSONObject(2).getString("courseName"));
            Log.d("Utility", "------------------------" + jsonArray.getJSONObject(0).length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //用GSON解析课表JSON数据
    public static List<GetCourse> parseJSONWithGSON3(String jsonData) {
        Gson gson = new Gson();
        GetCourse getCourse = null;
        List<GetCourse> list = new ArrayList<>();
        List<GetCourse> appList = gson.fromJson(jsonData, new TypeToken<List<GetCourse>>() {}.getType());
        for (GetCourse data : appList) {
            getCourse = new GetCourse();
            getCourse.setCourseName(data.getCourseName());
            getCourse.setClazz(data.getClazz());
            getCourse.setTeacher(data.getTeacher());
            list.add(getCourse);
            Log.d("Utility", "-----------------" + getCourse.getCourseName());
        }
        return list;
    }
}