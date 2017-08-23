package com.example.yang.myapplication.project.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.view.MvpActivity;

/**
 * Author : WaterFlower.
 * Created on 2017/8/23.
 * Desc :
 */

public class AddClientActivity extends MvpActivity<MvpBasePresenter> {


    public static Intent getIntent(Context context, String args) {
        Intent intent = new Intent(context, AddClientActivity.class);
        return intent;
    }

    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_add_client;
    }

    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        tbHolder.tvCenterTitle.setText("添加客户");
    }

    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {

    }

    @Override
    public void showContentView(String url, BaseVo dataVo) {

    }

}
