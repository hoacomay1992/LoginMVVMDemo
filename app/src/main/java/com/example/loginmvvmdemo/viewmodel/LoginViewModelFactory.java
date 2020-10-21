package com.example.loginmvvmdemo.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.loginmvvmdemo.interfaces.LoginResultCallBack;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginResultCallBack loginResultCallBack;

    public LoginViewModelFactory(LoginResultCallBack loginResultCallBack) {
        this.loginResultCallBack = loginResultCallBack;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(loginResultCallBack);
    }
}
