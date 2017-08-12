package com.example.yang.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.example.yang.myapplication.base.mvp.view.BaseActivity;

public class CommissionDetailActivity extends BaseActivity {


    @Override
    public int getViewLayout() {
        return R.layout.activity_commission_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent intent) {

    }


}
