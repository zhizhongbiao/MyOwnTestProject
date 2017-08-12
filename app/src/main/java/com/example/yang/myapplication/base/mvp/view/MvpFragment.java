package com.example.yang.myapplication.base.mvp.view;


import android.os.Bundle;
import android.view.View;

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

import butterknife.Unbinder;


/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :
 */

public abstract class MvpFragment<P extends MvpBasePresenter>  extends BaseFragment implements MvpView {

    protected P presenter;
    protected MaterialDialog progressDialog;
    private boolean loadSuccess;
    private boolean loadFinish; //请求是否成功
    private Unbinder unbinder;
    private Bundle savedInstanceState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<? extends MvpPresenter> presenterClass = (Class<? extends MvpPresenter>) type.getActualTypeArguments()[0];
        try {
            this.presenter = (P) presenterClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }

        presenter.attachView(this);
        progressDialog = new MaterialDialog.Builder(getActivity())
                .customView(R.layout.load_data_progress_layout, false)
                .cancelable(true).build();
        progressDialog.getWindow().getDecorView().setBackgroundColor(UIUtils.getColor(android.R.color.transparent));
        EventBus.getDefault().register(this);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.savedInstanceState=savedInstanceState;
        loadData(this.savedInstanceState);
    }

    /**
     * 获取请求参数，初始化vo对象，并发送请求
     *
     * @param savedInstanceState
     */
    protected abstract void loadData(Bundle savedInstanceState);

    @Override
    public void onLoading() {
        if (!progressDialog.isShowing()) {
            loadSuccess = false;
            progressDialog.show();
        }
    }

    @Override
    public void beforeSuccess() {
        loadSuccess = true;
        loadFinish = true;
    }


    @Override
    public void onError(ResponseInfo responseInfo) {
        loadFinish = true;
        switch (responseInfo.getState()) {
            case ResponseInfo.TIME_OUT:
                showTimeOutDialog(responseInfo);
                break;
            case ResponseInfo.NO_INTERNET_ERROR:
                showOpenNetworkDialog(responseInfo);
                break;
        }

    }

    private void showOpenNetworkDialog(ResponseInfo responseInfo) {
        ToastUtil.showLong("网络连接不可用，请打开网络！");
    }

    protected void showTimeOutDialog(ResponseInfo responseInfo) {
        ToastUtil.showLong("连接网络超时！");
    }


    @Subscribe
    public void onEvent(NetworkStateEvent networkStateEvent) {
        if (!networkStateEvent.hasNetworkConnected) {
            ToastUtil.showShort("网络连接已断开");
        } else {
            if (loadFinish && !loadSuccess) {
                //网络已连接数据没有加载成功，重新加载
                loadData( this.savedInstanceState);
            }
        }
    }

    @Override
    public void onStopLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
        presenter.detachView();
        presenter = null;
        EventBus.getDefault().unregister(this);
    }


}
