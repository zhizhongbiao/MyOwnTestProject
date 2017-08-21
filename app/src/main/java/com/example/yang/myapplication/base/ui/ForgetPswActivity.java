package com.example.yang.myapplication.base.ui;

import android.content.Intent;
import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.view.MvpActivity;

/**
 * Author : WaterFlower.
 * Created on 2017/8/14.
 * Desc :   忘记密码
 */

public class ForgetPswActivity extends MvpActivity<MvpBasePresenter> {


    @Override
    public int getViewLayout() {
        return R.layout.activity_forget_psw;
    }



    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent intent) {

    }

    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {

    }

    @Override
    public void showContentView(String url, BaseVo dataVo) {

    }
}
