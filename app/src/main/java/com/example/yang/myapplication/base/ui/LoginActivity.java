package com.example.yang.myapplication.base.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.MyApplication;
import com.example.yang.myapplication.base.bean.LoginBean;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.network.ApiConfig;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.utils.ToastUtil;
import com.example.yang.myapplication.base.mvp.view.MvpActivity;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Author : WaterFlower.
 * Created on 2017/8/14.
 * Desc :   登录密码
 */

public class LoginActivity extends MvpActivity<MvpBasePresenter> {


    @BindView(R.id.etLoginPhone)
    EditText etLoginPhone;
    @BindView(R.id.etLoginPsw)
    EditText etLoginPsw;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.tvForgetPsw)
    TextView tvForgetPsw;

    @Override
    public int getViewLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent intent) {
        inti();
    }

    private void inti() {
        etLoginPhone.setText("13826914162");
        etLoginPsw.setText("888888");
    }

    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {

    }

    @Override
    public void showContentView(String url, BaseVo dataVo) {
        if (url.contains(ApiConfig.API_LOGIN)) {
            ToastUtil.showShort("登录成功");
            startActivity(MainActivity.getIntent(this));
            ((MyApplication) getApplication()).setLogin(true);
            finish();
        }

    }


    @OnClick({R.id.btnLogin, R.id.tvForgetPsw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:

                String loginPhone = etLoginPhone.getText().toString().trim();
                String loginPsw = etLoginPsw.getText().toString().trim();
                if (TextUtils.isEmpty(loginPhone) || TextUtils.isEmpty(loginPsw)) {
                    ToastUtil.showLong("账号和密码不符");
                    return;
                }
                login(loginPhone, loginPsw);
                break;
            case R.id.tvForgetPsw:
                break;
        }
    }

    private void login(String loginPhone, String loginPsw) {
        ArrayMap<String, Serializable> params = new ArrayMap<>();
        params.put("username", loginPhone);
        params.put("password", loginPsw);
        presenter.postData(ApiConfig.API_LOGIN, params, LoginBean.class);
    }
}
