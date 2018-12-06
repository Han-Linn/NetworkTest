package com.example.andy.Util_Http;

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}