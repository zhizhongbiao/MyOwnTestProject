package com.example.yang.myapplication.base.mvp.view;


import android.content.Intent;
import android.os.Bundle;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.network.ResponseInfo;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.presenter.MvpPresenter;
import com.example.yang.myapplication.base.mvp.reveiver.NetworkStateEvent;
import com.example.yang.myapplication.base.mvp.utils.ToastUtil;
import com.example.yang.myapplication.base.mvp.utils.UIUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.ParameterizedType;

/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :
 */

public abstract class MvpActivity<P extends MvpBasePresenter> extends BaseActivity implements MvpView {

    protected P presenter;
    protected MaterialDialog progressDialog;
    private boolean loadSuccess; //数据是否加载成功
    private boolean loadFinish; //请求是否成功
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<? extends MvpPresenter> presenterClass = (Class<? extends MvpPresenter>) type.getActualTypeArguments()[0];
        try {
            this.presenter = (P) presenterClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        presenter.attachView(this);
        progressDialog = new MaterialDialog.Builder(this)
                .customView(R.layout.load_data_progress_layout, false)
                .cancelable(true).build();
        progressDialog.getWindow().getDecorView().setBackgroundColor(UIUtils.getColor(android.R.color.transparent));
        EventBus.getDefault().register(this);
        this.savedInstanceState = savedInstanceState;
        loadData(this.savedInstanceState, getIntent());
    }


    /**
     * 从intent中获取请求参数，初始化vo对象，并发送请求
     *
     * @param savedInstanceState
     * @param intent
     */
    protected abstract void loadData(Bundle savedInstanceState, Intent intent);


    @Override
    public void onLoading() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
            loadSuccess = false;
        }
    }


    @Override
    public void beforeSuccess() {
        loadSuccess = true;
        loadFinish = true;
    }


    @Override
    public void onStopLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onError(ResponseInfo responseInfo) {
        loadFinish = true;
    }


    /**
     * 网络状态改变事件，由子类重写实现相关的逻辑
     *
     * @param networkStateEvent
     */
    @Subscribe
    public void onEvent(NetworkStateEvent networkStateEvent) {
        if (!networkStateEvent.hasNetworkConnected) {
            ToastUtil.showShort("网络连接已断开!");
        } else {
            if (loadFinish && !loadSuccess) {
                //网络已连接数据没有加载成功，重新加载
                loadData(this.savedInstanceState, getIntent());
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        presenter = null;
        EventBus.getDefault().unregister(this);
    }

}
