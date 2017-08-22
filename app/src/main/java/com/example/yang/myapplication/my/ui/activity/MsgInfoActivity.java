package com.example.yang.myapplication.my.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.view.MvpActivity;
import com.example.yang.myapplication.my.adapter.MsgAdapter;

import butterknife.BindView;


/**
 * Author : WaterFlower.
 * Created on 2017/8/14.
 * Desc :   消息通知
 */
public class MsgInfoActivity extends MvpActivity<MvpBasePresenter> {

    @BindView(R.id.rv)
    RecyclerView rv;
    private MsgAdapter adapter;

    public static Intent getIntent(Context context, String args) {
        Intent intent = new Intent(context, MsgInfoActivity.class);
        return intent;
    }


    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_common_recyclerview;
    }


    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        tbHolder.tvCenterTitle.setText("消息通知");
        initRv();
    }

    private void initRv() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MsgAdapter();
        rv.setAdapter(adapter);
    }


    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {

    }


    @Override
    public void showContentView(String url, BaseVo dataVo) {

    }

}
