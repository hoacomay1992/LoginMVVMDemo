package com.example.loginmvvmdemo.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.loginmvvmdemo.interfaces.LoginResultCallBack;
import com.example.loginmvvmdemo.model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private LoginResultCallBack loginResultCallBack;

    public LoginViewModel(LoginResultCallBack loginResultCallBack) {
        this.loginResultCallBack = loginResultCallBack;
        this.user = new User();
    }

    //Write method to get email from edittext and set to user
    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    //Write method to get password from edittext and set to user
    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    //write method to process login
    public void onLoginClick(View view) {
        int errorCode = user.isValidData();
        if (errorCode == 0) {
            loginResultCallBack.onError("Your must enter email address");
        } else if (errorCode == 1) {
            loginResultCallBack.onError("Your email is invalid");
        } else if (errorCode == 2) {
            loginResultCallBack.onError("Password lenght must greater than 6 characters");
        } else {
            loginResultCallBack.onSuccess("Login Success");
        }
    }
}
