package com.example.andy.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class TestMain {
    //自定义Strig适配器
    private static final TypeAdapter STRING = new TypeAdapter() {
        @Override
        public void write(JsonWriter out, Object value) throws IOException {

        }

        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }

        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                // 在这里处理null改为空字符串
                writer.value("");
                return;
            }
            writer.value(value);
        }
    };

    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();

        //注册自定义String的适配器
        gsonBuilder.registerTypeAdapter(String.class, STRING);

        Gson gson = gsonBuilder.create();
        UserBean userBean = new UserBean();
        userBean.setId("1");
        System.out.println(gson.toJson(userBean));
    }
}