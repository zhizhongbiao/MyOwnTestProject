package com.example.yang.myapplication.my.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.view.BaseActivity;

/**
 * Author : WaterFlower.
 * Created on 2017/8/14.
 * Desc :   账号设置
 */


public class AccountSettingActivity extends BaseActivity {

    public static Intent getIntent(Context context, String args) {
        Intent intent = new Intent(context, AccountSettingActivity.class);
        return intent;
    }

    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_account_setting;
    }



    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        tbHolder.tvCenterTitle.setText("账号设置");
    }


}
