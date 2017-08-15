package com.example.yang.myapplication.base;

import com.example.yang.myapplication.base.mvp.MainApplication;

/**
 * Author : WaterFlower.
 * Created on 2017/8/15.
 * Desc :
 */

public class MyApplication extends MainApplication {

    private boolean isLogin = false;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

}
