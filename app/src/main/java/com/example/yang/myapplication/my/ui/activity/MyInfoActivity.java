package com.example.yang.myapplication.my.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.view.BaseActivity;

/**
 * Created by yang on 2017/8/8.
 */

public class MyInfoActivity extends BaseActivity {
    @Override
    public int getViewLayout() {
        return R.layout.activity_my_info;
    }


    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {

    }


}
