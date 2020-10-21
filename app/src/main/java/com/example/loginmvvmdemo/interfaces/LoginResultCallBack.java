package com.example.loginmvvmdemo.interfaces;

public interface LoginResultCallBack {
    void onSuccess(String message);
    void onError(String message);
}
