package com.example.andy.Util_Parse;

import android.util.Log;

import com.example.andy.JavaBean.Course;
import com.example.andy.JavaBean.App;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Utility {

    //用GSON解析预约JSON数据
    public static List<App> parseJSONWithGSON1(String jsonData) {
        App app = null;
        Gson gson = new Gson();
        List<App> list = new ArrayList<>();
        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>() {
        }.getType());
        for (App data : appList) {
            app = new App();
            app.setAppointMan(data.getAppointMan());
            app.setCreateTime(data.getCreateTime());
            app.setStartTime(data.getStartTime());
            app.setAddr(data.getAddr());
            app.setEndTime(data.getEndTime());
            app.setReason(data.getReason());
            list.add(app);
            Log.d("Utility", "-----------------" + app.getAppointMan());
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
    public static List<Course> parseJSONWithGSON2(String jsonData) {
        List<Course> list = new ArrayList<>();
        List<String> list_jsonArray = new LinkedList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            Course getcourse = null;
            String data = null;
            for(int i = 0; i < jsonArray.length(); i++){
                data = jsonArray.get(i).toString();
                list_jsonArray.add(data);
            }

            for (int i = 0; i < jsonArray.length(); i++) {
                if (list_jsonArray.get(i).equals("null")) {
                    getcourse = new Course();
                    getcourse.setClazz("");
                    getcourse.setCourseName("");
                    getcourse.setTeacher("");
                } else {
                    getcourse = new Course();
                    getcourse.setClazz(list_jsonArray.get(i).split("\\\"")[3]);
                    getcourse.setCourseName(list_jsonArray.get(i).split("\\\"")[7]);
                    getcourse.setTeacher(list_jsonArray.get(i).split("\\\"")[11]);
                }
                list.add(getcourse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}