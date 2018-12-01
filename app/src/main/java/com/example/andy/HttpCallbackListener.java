package com.example.andy;

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}