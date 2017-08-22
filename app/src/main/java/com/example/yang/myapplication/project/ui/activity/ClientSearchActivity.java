package com.example.yang.myapplication.project.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.utils.CommonTools;
import com.example.yang.myapplication.base.mvp.utils.CommonUtil;
import com.example.yang.myapplication.base.mvp.utils.ToastUtil;
import com.example.yang.myapplication.base.mvp.view.MvpActivity;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc : 客人搜索
 */

public class ClientSearchActivity extends MvpActivity<MvpBasePresenter> {

    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.tvEnsure)
    TextView tvEnsure;
    @BindView(R.id.rvClient)
    RecyclerView rvClient;

    public static Intent getIntent(Context context, String args) {
        Intent intent = new Intent(context, ClientSearchActivity.class);
        return intent;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_client_search;
    }


    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        initToolbar();
    }


    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {

    }


    @Override
    public void showContentView(String url, BaseVo dataVo) {

    }


    private void initToolbar() {

    }


    @OnClick({R.id.ivBack, R.id.tvEnsure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                CommonTools.hideKeyboard(etSearch);
                this.finish();
                break;
            case R.id.tvEnsure:
                String phoneNum = etSearch.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNum)||!CommonUtil.isMobileNum(phoneNum))
                {
                    ToastUtil.showShort("请输入有效手机号码");
                    return;
                }
                searchClientByPhone(phoneNum);
                break;
        }
    }

    private void searchClientByPhone(String phoneNum) {

    }
}
