package com.example.andy.Util_Http;

public interface OnResponseListner {
    void onSucess(String response);
    void onError(String error);
}