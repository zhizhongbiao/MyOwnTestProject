package com.example.yang.myapplication.my.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.utils.ToastUtil;
import com.example.yang.myapplication.base.mvp.view.WrapperMvpActivity;

import butterknife.OnClick;

/**
 * Author : WaterFlower.
 * Created on 2017/8/14.
 * Desc :   设置
 */

public class SettingActivity extends WrapperMvpActivity<MvpBasePresenter> {


    public static Intent getIntent(Context context, String args) {
        Intent intent = new Intent(context, SettingActivity.class);
        return intent;
    }


    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_setting;
    }


    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        tbHolder.tvCenterTitle.setText("设置");
    }

    @Override
    public void showContentView(String url, BaseVo dataVo) {

    }


    @OnClick({R.id.tvAccountSetting, R.id.tvMsgSetting, R.id.tvAbout, R.id.btnLogOut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvAccountSetting:
                startActivity(AccountSettingActivity.getIntent(this,"暂无参数"));
                break;
            case R.id.tvMsgSetting:
                startActivity(MsgSettingActivity.getIntent(this,"暂无参数"));
                break;
            case R.id.tvAbout:
                startActivity(AboutActivity.getIntent(this,"暂无参数"));
                break;
            case R.id.btnLogOut:
                logout();
                break;
        }
    }



    //登出账号
    private void logout() {
        ToastUtil.showShort("登出");
    }


}
