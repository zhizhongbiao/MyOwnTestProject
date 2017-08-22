package com.example.yang.myapplication.base.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.view.MvpActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author : WaterFlower.
 * Created on 2017/8/14.
 * Desc :   忘记密码
 */

public class ForgetPswActivity extends MvpActivity<MvpBasePresenter> {


    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etSMSCode)
    EditText etSMSCode;
    @BindView(R.id.etNewPsw)
    EditText etNewPsw;
    @BindView(R.id.etEnsureNewPsw)
    EditText etEnsureNewPsw;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, ForgetPswActivity.class);
        return intent;
    }


    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_forget_psw;
    }


    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        tbHolder.tvCenterTitle.setText("忘记密码");
    }

    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {

    }

    @Override
    public void showContentView(String url, BaseVo dataVo) {

    }




    @OnClick({R.id.tvGetSMSCode, R.id.btnLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvGetSMSCode:
                getSMSCode();
                break;
            case R.id.btnLogin:

                break;
        }
    }


    /**
     * 获取验证码
     */
    public void getSMSCode() {

    }
}
